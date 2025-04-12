package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.MerchantForgotPasswordDTO;
import com.secondhand1.pojo.dto.MerchantLoginDTO;
import com.secondhand1.pojo.dto.MerchantRegisterDTO;
import com.secondhand1.pojo.dto.MerchantResetPasswordDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.service.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商家注册与登录
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "商家注册与登录")
@RequestMapping("merchant")
@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    /**
     * register
     *
     * @param registerDTO 商家注册入参实体
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "register")
    @ResponseBody
    public RestResult<Boolean> registerMerchant(@RequestBody @Validated(CreateGroup.class) MerchantRegisterDTO registerDTO) {
        Boolean result = merchantService.registerMerchant(registerDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * login
     *
     * @param loginDTO 商家登录入参实体
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "login")
    @ResponseBody
    public RestResult<String> loginMerchant(@RequestBody @Validated(QueryGroup.class) MerchantLoginDTO loginDTO) {
        String result = merchantService.loginMerchant(loginDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 忘记密码
     *
     * @param forgotPasswordDTO 商家忘记密码入参实体
     * @return
     */
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    @Operation(summary = "forgot-password")
    @ResponseBody
    public RestResult<Boolean> forgotPassword(@RequestBody @Validated(QueryGroup.class) MerchantForgotPasswordDTO forgotPasswordDTO) {
        Boolean result = merchantService.forgotPassword(forgotPasswordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * reset-password
     *
     * @param resetPasswordDTO 商家重置密码入参实体
     * @return
     */
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @Operation(summary = "reset-password")
    @ResponseBody
    public RestResult<Boolean> resetPassword(@RequestBody @Validated(QueryGroup.class) MerchantResetPasswordDTO resetPasswordDTO) {
        Boolean result = merchantService.resetPassword(resetPasswordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
