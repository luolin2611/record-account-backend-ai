package cn.rollin.passwordassistant.service;

import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.pojo.dto.HomeStatisticsRes;
import cn.rollin.passwordassistant.pojo.dto.RecordAccountReq;

public interface IHomeService {
    
    /**
     * 获取首页统计数据
     *
     * @param userId 用户ID
     * @return 统计数据
     */
    Response<HomeStatisticsRes> getHomeStatistics(Long userId);
    
    /**
     * 记账
     *
     * @param userId 用户ID
     * @param req    记账请求
     * @return 操作结果
     */
    Response<Object> recordAccount(Long userId, RecordAccountReq req);
} 
