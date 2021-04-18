package com.pig.easy.bpm.generator.dto.response;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.alibaba.excel.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.math.*;
/**
 * <p>
    * 数据源表
    * </p>
 *
 * @author pig
 * @since 2021-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DbConfigExportDTO implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    /**
     * 数据源编号
     */
    @ExcelProperty( value = "数据源编号")
    private Long  dbId;

    /**
     * 数据源名称
     */
    @ExcelProperty( value = "数据源名称")
    private String  dbName;

    /**
     * url
     */
    @ExcelProperty( value = "url")
    private String  dbUrl;

    /**
     * 用户名
     */
    @ExcelProperty( value = "用户名")
    private String  dbUsername;

    /**
     * 密码
     */
    @ExcelProperty( value = "密码")
    private String  dbPassword;

    /**
     * 数据源类型
     */
    @ExcelProperty( value = "数据源类型")
    private String  dbType;

    /**
     * 登记目录
     */
    @ExcelProperty( value = "登记目录")
    private String  dbCatalog;

    /**
     * 数据源库名
     */
    @ExcelProperty( value = "数据源库名")
    private String  dbSchemaName;

    /**
     * 驱动名称
     */
    @ExcelProperty( value = "驱动名称")
    private String  dbDriverName;

    /**
     * 租户编号
     */
    @ExcelProperty( value = "租户编号")
    private String  tenantId;

    /**
     * 备注
     */
    @ExcelProperty( value = "备注")
    private String  remarks;

    /**
     * 状态 1 有效 0 失效
     */
    @ExcelProperty( value = "状态")
    private Integer  validState;

    /**
     * 操作人工号
     */
    @ExcelProperty( value = "操作人工号")
    private Integer  operatorId;

    /**
     * 操作人姓名
     */
    @ExcelProperty( value = "操作人姓名")
    private String  operatorName;

    /**
     * 创建时间
     */
    @ExcelProperty( value = "创建时间")
    private LocalDateTime  createTime;

    /**
     * 更新时间
     */
    @ExcelProperty( value = "更新时间")
    private LocalDateTime  updateTime;
}
