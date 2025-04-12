package com.secondhand1.service;

import com.secondhand1.pojo.dto.*;

import java.lang.Boolean;

/**
 * 用户与商家信息管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface UserMerchantProductService {

    /**
     * 修改用户个人信息
     *
     * @param updateuserDTO 用户注册信息
     * @return
     */
    Boolean updateUser(UpdateUserDTO updateuserDTO);

    /**
     * 修改商家店铺信息
     *
     * @param merchantDTO 商家入参实体
     * @return
     */
    Boolean updateMerchant(UpdateMerchantDTO merchantDTO);

    /**
     * 修改商品信息
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    Boolean updateProduct1(ProductDTO productDTO);
}
