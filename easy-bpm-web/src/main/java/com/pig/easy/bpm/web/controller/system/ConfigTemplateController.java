package com.pig.easy.bpm.web.controller.system;


import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.pig.easy.bpm.auth.core.controller.BaseController;
import com.pig.easy.bpm.auth.dto.request.ConfigTemplateQueryDTO;
import com.pig.easy.bpm.auth.dto.request.ConfigTemplateSaveOrUpdateDTO;
import com.pig.easy.bpm.auth.dto.response.ConfigTemplateDTO;
import com.pig.easy.bpm.auth.dto.response.ConfigTemplateExportDTO;
import com.pig.easy.bpm.auth.service.ConfigTemplateService;
import com.pig.easy.bpm.common.converter.LocalDateTimeConverter;
import com.pig.easy.bpm.common.entityError.EntityError;
import com.pig.easy.bpm.common.utils.BeanUtils;
import com.pig.easy.bpm.common.utils.EasyBpmAsset;
import com.pig.easy.bpm.common.utils.JsonResult;
import com.pig.easy.bpm.common.utils.Result;
import com.pig.easy.bpm.web.vo.request.ConfigTemplateQueryVO;
import com.pig.easy.bpm.web.vo.request.ConfigTemplateSaveOrUpdateVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pig
 * @since 2021-03-20
 */
@RestController
@RequestMapping("/configTemplate")
public class ConfigTemplateController extends BaseController {

    @Autowired
    ConfigTemplateService service;

    @ApiOperation(value = "查询列表", notes = "查询列表", produces = "application/json")
    @PostMapping("/getListPage")
    public JsonResult getListPage(@Valid @RequestBody ConfigTemplateQueryVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, ConfigTemplateQueryDTO.class);

        Result<PageInfo<ConfigTemplateDTO>> result = service.getListPageByCondition(queryDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "查询列表", notes = "查询列表", produces = "application/json")
    @PostMapping("/getList")
    public JsonResult getList(@Valid @RequestBody ConfigTemplateQueryVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, ConfigTemplateQueryDTO.class);

        Result<List<ConfigTemplateDTO>> result = service.getListByCondition(queryDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "新增", notes = "新增", produces = "application/json")
    @PostMapping("/insert")
    public JsonResult insertConfigTemplate(@Valid @RequestBody ConfigTemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, ConfigTemplateSaveOrUpdateDTO.class);

        Result<Integer> result = service.insertConfigTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "修改", notes = "修改", produces = "application/json")
    @PostMapping("/update")
    public JsonResult updateConfigTemplate(@Valid @RequestBody ConfigTemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, ConfigTemplateSaveOrUpdateDTO.class);

        Result<Integer> result = service.updateConfigTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
          return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "删除", notes = "删除", produces = "application/json")
    @PostMapping("/deleteById")
    public JsonResult deleteById(@Valid @RequestBody ConfigTemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateSaveOrUpdateDTO saveDTO = BeanUtils.switchToDTO(param, ConfigTemplateSaveOrUpdateDTO.class);
        saveDTO.setValidState(0);

        Result<Integer> result = service.deleteConfigTemplate(saveDTO);
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }

    @ApiOperation(value = "下载", notes = "下载", produces = "application/json")
    @PostMapping("download")
    public void download(HttpServletResponse response,@Valid @RequestBody ConfigTemplateQueryVO param) throws IOException {

        EasyBpmAsset.isAssetEmpty(param);
        ConfigTemplateQueryDTO queryDTO = BeanUtils.switchToDTO(param, ConfigTemplateQueryDTO.class);

        Result<List<ConfigTemplateDTO>> result = service.getListByCondition(queryDTO);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = String.valueOf(System.currentTimeMillis()) + ".xlsx";
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        EasyExcel.write(response.getOutputStream(), ConfigTemplateExportDTO.class).registerConverter(new LocalDateTimeConverter()).sheet().doWrite(result.getData());
    }

    @ApiOperation(value = "根据编号获取", notes = "根据编号获取", produces = "application/json")
    @PostMapping("/getById")
    public JsonResult getById(@Valid @RequestBody ConfigTemplateSaveOrUpdateVO param) {

        EasyBpmAsset.isAssetEmpty(param);
        EasyBpmAsset.isAssetEmpty(param.getTemplateId());

        Result<ConfigTemplateDTO> result = service.getConfigTemplateById(param.getTemplateId());
        if (result.getEntityError().getCode() != EntityError.SUCCESS.getCode()) {
            return JsonResult.error(result.getEntityError());
        }
        return JsonResult.success(result.getData());
    }
}
