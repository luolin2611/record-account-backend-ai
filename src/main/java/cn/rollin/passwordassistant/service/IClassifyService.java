package cn.rollin.passwordassistant.service;

import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.pojo.entity.Classify;

import java.util.List;

public interface IClassifyService {
    
    /**
     * 获取所有分类列表
     *
     * @param type 支付类型(可选)：0-支出，1-收入
     * @return 分类列表
     */
    Response<List<Classify>> getAllClassifies(String type);
} 