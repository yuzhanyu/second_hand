package com.secondhand1.service.impl;

import com.secondhand1.dao.MerchantMapper;
import com.secondhand1.dao.ProductMapper;
import com.secondhand1.dao.UserMapper;
import com.secondhand1.pojo.dto.*;
import com.secondhand1.service.UserMerchantProductService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import com.secondhand1.pojo.domain.MerchantDO;
import com.secondhand1.pojo.domain.UserDO;
import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.ProductDO;
import java.util.Date;

/**
 * 用户与商家信息管理模块的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class UserMerchantProductServiceImpl implements UserMerchantProductService {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserMerchantProductServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Boolean updateUser(UpdateUserDTO updateuserDTO) {
        UserDO existingUser = userMapper.selectById(updateuserDTO.getUserId());
        if (existingUser == null) {
            logger.error("User not found with ID: {}", updateuserDTO.getUserId());
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (userMapper.isEmailUsedByOtherUser(updateuserDTO.getUserId(), updateuserDTO.getEmail())) {
            logger.error("Email already used by another user: {}", updateuserDTO.getEmail());
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setUserId(updateuserDTO.getUserId());
        userDO.setUsername(updateuserDTO.getUsername());
        userDO.setEmail(updateuserDTO.getEmail());
        userDO.setPhone(updateuserDTO.getPhone());
        userDO.setAddress(updateuserDTO.getAddress());
        userDO.setStatus(updateuserDTO.getStatus());
        userDO.setUpdateBy(updateuserDTO.getUserId());
        userDO.setUpdateTime(new Date());
        userMapper.updateById1(userDO);
        return true;
    }

    @Override
    public Boolean updateMerchant(UpdateMerchantDTO updatemerchantDTO) {
        MerchantDO existingMerchant = merchantMapper.selectById(updatemerchantDTO.getMerchantId());
        if (existingMerchant == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (merchantMapper.isEmailUsedByOtherMerchant(updatemerchantDTO.getMerchantId(), updatemerchantDTO.getEmail())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setMerchantId(updatemerchantDTO.getMerchantId());
        merchantDO.setUsername(updatemerchantDTO.getUsername());
        merchantDO.setEmail(updatemerchantDTO.getEmail());
        merchantDO.setPhone(updatemerchantDTO.getPhone());
        merchantDO.setAddress(updatemerchantDTO.getAddress());
        merchantDO.setUpdateBy(updatemerchantDTO.getMerchantId());
        merchantDO.setStoreName(updatemerchantDTO.getStoreName());
        merchantDO.setStatus(updatemerchantDTO.getStatus());
        merchantDO.setUpdateTime(new Date());
        merchantMapper.updateById1(merchantDO);
        return true;
    }

    @Override
    public Boolean updateProduct1(ProductDTO productDTO) {
        ProductDO existingProduct = productMapper.selectById(productDTO.getProductId());
        if (existingProduct == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProductDO productDO = new ProductDO();
        productDO.setProductId(productDTO.getProductId());
        productDO.setMerchantId(productDTO.getMerchantId());
        productDO.setName(productDTO.getName());
        productDO.setDescription(productDTO.getDescription());
        productDO.setPrice(productDTO.getPrice());
        productDO.setStock(productDTO.getStock());
        productDO.setCategoryId(productDTO.getCategoryId());
        productDO.setStatus(productDTO.getStatus());
        productDO.setUpdateBy(productDTO.getMerchantId());
        productDO.setUpdateTime(new Date());
        productMapper.updateById(productDO);
        return true;
    }
}
