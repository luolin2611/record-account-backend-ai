package cn.rollin.passwordassistant.controller;

import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.common.utils.UserContext;
import cn.rollin.passwordassistant.pojo.dto.HomeStatisticsRes;
import cn.rollin.passwordassistant.pojo.dto.RecordAccountReq;
import cn.rollin.passwordassistant.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    /**
     * 获取首页统计数据
     *
     * @return 统计数据
     */
    @GetMapping("/statistics")
    public Response<HomeStatisticsRes> getHomeStatistics() {
        Long userId = UserContext.getUser().getUserId();
        return homeService.getHomeStatistics(userId);
    }
    
    /**
     * 记账
     *
     * @param req 记账请求
     * @return 操作结果
     */
    @PostMapping("/record")
    public Response<Object> recordAccount(@RequestBody @Validated RecordAccountReq req) {
        Long userId = UserContext.getUser().getUserId();
        return homeService.recordAccount(userId, req);
    }
}
