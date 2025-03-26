package cn.rollin.passwordassistant.controller;

import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.pojo.entity.Classify;
import cn.rollin.passwordassistant.service.IClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类Controller
 *
 * @author rollin
 * @date 2025-03-24 22:19:37
 */
@Slf4j
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private IClassifyService classifyService;

    /**
     * 获取所有分类列表
     *
     * @param type 支付类型(可选)：0-支出，1-收入
     * @return 分类列表
     */
    @GetMapping("/list")
    public Response<List<Classify>> getAllClassifies(@RequestParam(name = "type", required = false) String type) {
        return classifyService.getAllClassifies(type);
    }
}
