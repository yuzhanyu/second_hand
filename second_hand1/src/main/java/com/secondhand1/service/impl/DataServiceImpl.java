package com.secondhand1.service.impl;

import com.secondhand1.dao.MerchantMapper;
import com.secondhand1.dao.OrderMapper;
import com.secondhand1.dao.ProductMapper;
import com.secondhand1.pojo.domain.*;
import com.secondhand1.pojo.dto.ImportProductDataDTO;
import com.secondhand1.pojo.query.ExportDataQuery;
import com.secondhand1.service.DataService;
import java.lang.Boolean;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;

import com.secondhand1.constant.ResultCodeConstant;

/**
 * 数据导入导出模块的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderItemDO> exportOrderData(ExportDataQuery exportDataQuery) {
        MerchantDO merchantDO = merchantMapper.selectById(exportDataQuery.getMerchantId());
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        List<OrderItemDO> orderItemDOList = orderMapper.selectOrderItemsByMerchantId(Long.valueOf(exportDataQuery.getMerchantId()));
        return orderItemDOList;
    }

    @Override
    public List<ProductDO> exportProductData(ExportDataQuery exportDataQuery) {
        MerchantDO merchantDO = merchantMapper.selectById(exportDataQuery.getMerchantId());
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        List<ProductDO> productDOList = productMapper.selectByMerchantId(exportDataQuery.getMerchantId());
        return productDOList;
    }

    @Override
    public Boolean importProductData(ImportProductDataDTO importProductDataDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(importProductDataDTO.getMerchantId());
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        for (ProductDO productDO : importProductDataDTO.getProducts()) {
            if (productDO.getName() == null || productDO.getPrice() == null || productDO.getStock() == null) {
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            productMapper.insert(productDO);
        }
        return true;
    }

    @Override
    public List<CategoryDO> exportCategoryData() {
        List<CategoryDO> categoryDOList = productMapper.selectAllCategories();
        return categoryDOList;
    }
}
