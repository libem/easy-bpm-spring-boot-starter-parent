package com.pig.easy.bpm.web.vo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 变量表
 * </p>
 *
 * @author pig
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VariableDictQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Long> processIdList;

    private String processKey;

    /**
     * 编号 
     */
    private Long  variableId;


    /**
     * 流程编号
     */
    private Long  processId;


    /**
     * 租户编号
     */
    private String  tenantId;


    /**
     * 字段英文名称
     */
    private String  dataKey;


    /**
     * 字段中文名称
     */
    private String  dataName;


    /**
     * 数据类型
     */
    private String  dataType;


    /**
     * 校验规则（填写JUEL表达式）
     */
    private String  checkRule;


    /**
     * 特殊值1
     */
    private String  specialValue;


    /**
     * 特殊值2
     */
    private String  specialValue2;


    /**
     * 1 流程变量 0 非流程变量
     */
    private Boolean  processData;


    /**
     * 排序值
     */
    private Integer  sort;


    /**
     * 允许编辑节点 默认发起人可以编辑字段
     */
    private String  allowEditNodeId;


    /**
     * 不允许读取字段 默认所有节点都可以读取
     */
    private String  hiddenNodeId;


    /**
     * 哪些节点当前字段必须传
     */
    private String  requiredNodeId;


    /**
     * 备注
     */
    private String  remarks;


    /**
     * 状态 1 有效 0 失效
     */
    private Integer  validState;


    /**
     * 操作人工号
     */
    private Long  operatorId;


    /**
     * 操作人姓名
     */
    private String  operatorName;


    /**
     * 创建时间
     */
    private LocalDateTime  createTime;


    /**
     * 更新时间
     */
    private LocalDateTime  updateTime;



    /**
     *  当前页码
     */
    private Integer pageIndex;

    /**
     * 每页展示数量
     */
    private Integer pageSize;

}
