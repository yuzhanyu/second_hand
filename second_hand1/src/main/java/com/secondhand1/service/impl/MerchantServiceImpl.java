package com.secondhand1.service.impl;

import com.secondhand1.config.JwtConfig;
import com.secondhand1.dao.MerchantMapper;
import com.secondhand1.pojo.domain.MerchantDO;
import com.secondhand1.pojo.dto.MerchantForgotPasswordDTO;
import com.secondhand1.pojo.dto.MerchantLoginDTO;
import com.secondhand1.pojo.dto.MerchantRegisterDTO;
import com.secondhand1.pojo.dto.MerchantResetPasswordDTO;
import com.secondhand1.service.MerchantService;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import javax.mail.MessagingException;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import com.secondhand1.exception.BusinessException;
import java.security.MessageDigest;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 商家注册与登录的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public Boolean registerMerchant(MerchantRegisterDTO registerDTO) {
        // 验证用户名和邮箱是否已存在
        MerchantDO existingMerchant = merchantMapper.selectByUsernameOrEmail(registerDTO.getUsername(), null);
        if (existingMerchant != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }

        // 对密码进行加密
        String encryptedPassword = encryptPassword(registerDTO.getPassword());
        // 将商家信息保存到数据库
        MerchantDO merchantDO = new MerchantDO();
        // 生成登录令牌
        String loginToken = generateLoginToken(merchantDO);
        System.out.println("注册成功，令牌：" + loginToken);
        merchantDO.setResetToken(loginToken);
        merchantDO.setUsername(registerDTO.getUsername());
        merchantDO.setPasswordHash(encryptedPassword);
        merchantDO.setEmail(registerDTO.getEmail());
        merchantDO.setPhone(registerDTO.getPhone());
        merchantDO.setAddress(registerDTO.getAddress());
        merchantDO.setStoreName(registerDTO.getStoreName());
        merchantDO.setStatus("active");
        merchantDO.setCreateTime(new Date());
        merchantDO.setUpdateTime(new Date());
        int result = merchantMapper.insert(merchantDO);
        return result > 0;
    }

    @Override
    public String loginMerchant(MerchantLoginDTO loginDTO) {
        // 验证用户名或邮箱是否存在
        MerchantDO merchantDO = merchantMapper.selectByUsernameOrEmail(loginDTO.getUsername(), null);
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 验证密码是否正确
        String encryptedPassword = encryptPassword(loginDTO.getPassword());
        if (!encryptedPassword.equals(merchantDO.getPasswordHash())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 生成登录令牌
        String loginToken = generateLoginToken(merchantDO);
        System.out.println("登录成功，登录令牌：" + loginToken);
        return loginToken;
    }

    @Override
    public Boolean forgotPassword(MerchantForgotPasswordDTO forgotPasswordDTO) {
        // 验证用户名或邮箱是否存在
        MerchantDO merchantDO = merchantMapper.selectByUsernameOrEmail(forgotPasswordDTO.getUsernameOrEmail(), null);
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 生成密码重置令牌并发送邮件
        String resetToken = generateResetPasswordToken(merchantDO);
        merchantDO.setResetToken(resetToken);
        System.out.println("重置密码成功，重置令牌：" + resetToken);
        return true;
    }

    @Override
    public Boolean resetPassword(MerchantResetPasswordDTO resetPasswordDTO) {
        // 验证重置令牌是否有效
        MerchantDO merchantDO = merchantMapper.selectByResetToken(resetPasswordDTO.getToken());
        if (merchantDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 对新密码进行加密
        String encryptedNewPassword = encryptPassword(resetPasswordDTO.getNewPassword());
        // 更新商家密码
        merchantDO.setPasswordHash(encryptedNewPassword);
        merchantDO.setResetToken(null);
        merchantDO.setUpdateTime(new Date());
        int result = merchantMapper.updateById(merchantDO);
        System.out.println("重置密码成功,新密码："+merchantDO.getPasswordHash());
        return result > 0;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败", e);
        }
    }

    private String generateLoginToken(MerchantDO merchantDO) {
        long expirationTime = 3600000L; // 1小时
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        // 使用JWT生成登录令牌
        return Jwts.builder()
                .setSubject(merchantDO.getUsername()) // 用户名作为主题
                .claim("userId", merchantDO.getMerchantId()) // 添加用户ID作为自定义声明
                .setIssuedAt(now) // 签发时间
                .setExpiration(expiryDate) // 过期时间
                .signWith(jwtConfig.getSecret()) // 使用密钥签名
                .compact();
    }

    private String generateResetPasswordToken(MerchantDO merchantDO) {
        String token = merchantDO.getUsername() + System.currentTimeMillis();
        merchantDO.setResetToken(token);
        merchantMapper.updateById(merchantDO);
        return token;
    }

}
