package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.dto.*;
import com.secondhand1.service.UserMerchantProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户与商家信息管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "用户与商家信息管理模块")
@RequestMapping("user-merchant-product")
@RestController
public class UserMerchantProductController {

    @Autowired
    private UserMerchantProductService userMerchantProductService;

    /**
     * 修改用户个人信息
     *
     * @param updateuserDTO 用户注册信息
     * @return
     */
    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    @Operation(summary = "修改用户个人信息")
    @ResponseBody
    public RestResult<Boolean> updateUser(@RequestBody @Validated(UpdateGroup.class) UpdateUserDTO updateuserDTO) {
        Boolean result = userMerchantProductService.updateUser(updateuserDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改商家店铺信息
     *
     * @param merchantDTO 商家入参实体
     * @return
     */
    @RequestMapping(value = "/update-merchant", method = RequestMethod.PUT)
    @Operation(summary = "修改商家店铺信息")
    @ResponseBody
    public RestResult<Boolean> updateMerchant(@RequestBody @Validated(UpdateGroup.class) UpdateMerchantDTO merchantDTO) {
        Boolean result = userMerchantProductService.updateMerchant(merchantDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改商品信息
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    @RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    @Operation(summary = "修改商品信息")
    @ResponseBody
    public RestResult<Boolean> updateProduct1(@RequestBody @Validated(UpdateGroup.class) ProductDTO productDTO) {
        Boolean result = userMerchantProductService.updateProduct1(productDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
