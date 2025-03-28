package cn.rollin.passwordassistant.controller;

import cn.rollin.passwordassistant.common.utils.UserContext;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY;

/**
 * Ai Controller
 *
 * @author rollin
 * @since 2025-03-26 22:59:04
 */
@RestController
@RequestMapping("/ai")
public class AiController {
    private ChatClient chatClient;

    private ChatMemory chatMemory;

    private VectorStore vectorStore;

    public AiController(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        您是"记账呀"网站的智能助手。请以友好、乐于助⼈且愉快的⽅式来回复。
                        您正在通过在线聊天系统与客户互动。
                        在提供有记账信息之前，您必须始终从⽤户处获取以下信息：
                            记账日期、账单金额、支付类型(classifyType 收入-取值为0、支出-取值为1)、分类id、描述信息(总结内容得出描述信息)。
                        在询问⽤户之前，请检查消息历史记录以获取此信息。
                        请讲中⽂。
                        在记账之前，请先获取记账信息等用户回复"确定"之后才进行调用记账的function-call
                        今天的⽇期是 {current_date}，当前登录的用户信息{loginUser}.
                        """)
                .defaultFunctions("recordByAi")
                .defaultAdvisors(
                        new PromptChatMemoryAdvisor(chatMemory),
                        new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @CrossOrigin
    @GetMapping(value = "/record", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> generateStreamAsString(@RequestParam(value = "message", defaultValue = "讲个笑话") String message) {
        Flux<String> content = chatClient.prompt()
                .user(message)
                .system(s -> s.param("current_date", LocalDateTime.now().toString()).param("loginUser", UserContext.getUser()))
                .advisors(memory -> memory.param(CHAT_MEMORY_RETRIEVE_SIZE_KEY, 100))
                .stream()
                .content();
        return content
                .doOnNext(System.out::println)
                .concatWith(Flux.just("[complete]"));
    }

}
