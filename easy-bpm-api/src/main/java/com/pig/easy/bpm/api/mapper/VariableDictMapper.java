package com.pig.easy.bpm.api.mapper;

import com.pig.easy.bpm.api.entity.VariableDictDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.pig.easy.bpm.api.dto.request.*;
import com.pig.easy.bpm.api.dto.response.*;

import java.util.List;
/**
 * <p>
 * 变量表 Mapper 接口
 * </p>
 *
 * @author pig
 * @since 2021-04-11
 */
@Mapper
public interface VariableDictMapper extends BaseMapper<VariableDictDO> {

    List<VariableDictDTO> getListByCondition(VariableDictQueryDTO param);

}
