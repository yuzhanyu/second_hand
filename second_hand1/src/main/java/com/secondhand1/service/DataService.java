package com.secondhand1.service;

import com.secondhand1.pojo.domain.CategoryDO;
import com.secondhand1.pojo.domain.OrderItemDO;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.dto.ImportProductDataDTO;
import com.secondhand1.pojo.query.ExportDataQuery;
import java.lang.Boolean;
import java.util.List;

/**
 * 数据导入导出模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface DataService {

    /**
     * 导出订单数据: 根据商家ID获取订单数据
     *
     * @param exportDataQuery 导出数据查询对象
     * @return
     */
    List<OrderItemDO> exportOrderData(ExportDataQuery exportDataQuery);

    /**
     * 导出商品数据: 根据商家ID获取商品数据
     *
     * @param exportDataQuery 导出数据查询对象
     * @return
     */
    List<ProductDO> exportProductData(ExportDataQuery exportDataQuery);

    /**
     * 导入商品数据: 根据商家ID导入商品数据
     *
     * @param importProductDataDTO 导入商品数据对象
     * @return
     */
    Boolean importProductData(ImportProductDataDTO importProductDataDTO);

    /**
     * 导出分类数据: 获取所有商品分类数据
     *
     * @return
     */
    List<CategoryDO> exportCategoryData();
}
