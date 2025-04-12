package com.secondhand1.service;

import com.secondhand1.pojo.dto.MerchantForgotPasswordDTO;
import com.secondhand1.pojo.dto.MerchantLoginDTO;
import com.secondhand1.pojo.dto.MerchantRegisterDTO;
import com.secondhand1.pojo.dto.MerchantResetPasswordDTO;
import java.lang.Boolean;
import java.lang.String;

/**
 * 商家注册与登录
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface MerchantService {

    /**
     * register
     *
     * @param registerDTO 商家注册入参实体
     * @return
     */
    Boolean registerMerchant(MerchantRegisterDTO registerDTO);

    /**
     * login
     *
     * @param loginDTO 商家登录入参实体
     * @return
     */
    String loginMerchant(MerchantLoginDTO loginDTO);

    /**
     * forgot-password
     *
     * @param forgotPasswordDTO 商家忘记密码入参实体
     * @return
     */
    Boolean forgotPassword(MerchantForgotPasswordDTO forgotPasswordDTO);

    /**
     * reset-password
     *
     * @param resetPasswordDTO 商家重置密码入参实体
     * @return
     */
    Boolean resetPassword(MerchantResetPasswordDTO resetPasswordDTO);
}
