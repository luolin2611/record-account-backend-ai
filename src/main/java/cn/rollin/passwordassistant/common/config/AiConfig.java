package cn.rollin.passwordassistant.common.config;

import cn.rollin.passwordassistant.common.utils.UserContext;
import cn.rollin.passwordassistant.pojo.dto.LoginUser;
import cn.rollin.passwordassistant.pojo.dto.RecordAccountReq;
import cn.rollin.passwordassistant.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

/**
 * Ai 相关的Bean
 *
 * @author rollin
 * @since 2025-03-26 23:18:05
 */
@Configuration
public class AiConfig {

    @Autowired
    private IHomeService homeService;

    private record RecordAccountAiReq(LoginUser loginUser, RecordAccountReq recordAccountReq) {
    }

    /**
     * 记账function call
     *
     * @return 记账结果
     */
    @Bean
    @Description("处理记账功能")
    public Function<RecordAccountAiReq, Object> recordByAi() {
        return recordAccountAiReq -> {
            // 验证是否登录
            UserContext.setUser(recordAccountAiReq.loginUser);
            // 执行记账
            return homeService.recordAccount(recordAccountAiReq.loginUser.getUserId(), recordAccountAiReq.recordAccountReq);
        };
    }
}
