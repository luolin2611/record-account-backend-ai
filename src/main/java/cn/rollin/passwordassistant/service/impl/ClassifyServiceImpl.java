package cn.rollin.passwordassistant.service.impl;

import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.mapper.ClassifyMapper;
import cn.rollin.passwordassistant.pojo.entity.Classify;
import cn.rollin.passwordassistant.service.IClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassifyServiceImpl implements IClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public Response<List<Classify>> getAllClassifies(String type) {
        List<Classify> classifies = classifyMapper.getAllClassifies(type);
        return Response.buildSuccess(classifies);
    }
} 