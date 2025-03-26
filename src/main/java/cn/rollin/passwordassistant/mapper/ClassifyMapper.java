package cn.rollin.passwordassistant.mapper;

import cn.rollin.passwordassistant.pojo.entity.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 获取所有分类列表
     *
     * @param type 支付类型(可选)：0-支出，1-收入
     * @return 分类列表
     */
    List<Classify> getAllClassifies(@Param("type") String type);
}
