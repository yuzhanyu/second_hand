package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.CategoryDO;
import com.secondhand1.pojo.domain.OrderItemDO;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.ImportProductDataDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.ExportDataQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据导入导出模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "数据导入导出模块")
@RequestMapping("data")
@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 导出订单数据: 根据商家ID获取订单数据
     *
     * @param exportDataQuery 导出数据查询对象
     * @return
     */
    @RequestMapping(value = "/export/orders", method = RequestMethod.GET)
    @Operation(summary = "导出订单数据: 根据商家ID获取订单数据")
    public RestResult<List<OrderItemDO>> exportOrderData(@Validated(QueryGroup.class) ExportDataQuery exportDataQuery) {
        List<OrderItemDO> result = dataService.exportOrderData(exportDataQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 导出商品数据: 根据商家ID获取商品数据
     *
     * @param exportDataQuery 导出数据查询对象
     * @return
     */
    @RequestMapping(value = "/export/products", method = RequestMethod.GET)
    @Operation(summary = "导出商品数据: 根据商家ID获取商品数据")
    public RestResult<List<ProductDO>> exportProductData(@Validated(QueryGroup.class) ExportDataQuery exportDataQuery) {
        List<ProductDO> result = dataService.exportProductData(exportDataQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 导入商品数据: 根据商家ID导入商品数据
     *
     * @param importProductDataDTO 导入商品数据对象
     * @return
     */
    @RequestMapping(value = "/import/products", method = RequestMethod.POST)
    @Operation(summary = "导入商品数据: 根据商家ID导入商品数据")
    @ResponseBody
    public RestResult<Boolean> importProductData(@RequestBody @Validated(CreateGroup.class) ImportProductDataDTO importProductDataDTO) {
        Boolean result = dataService.importProductData(importProductDataDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 导出分类数据: 获取所有商品分类数据
     *
     * @return
     */
    @RequestMapping(value = "/export/categories", method = RequestMethod.GET)
    @Operation(summary = "导出分类数据: 获取所有商品分类数据")
    public RestResult<List<CategoryDO>> exportCategoryData() {
        List<CategoryDO> result = dataService.exportCategoryData();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
