package com.secondhand1.service.impl;

import com.secondhand1.config.JwtConfig;
import com.secondhand1.dao.UserMapper;
import com.secondhand1.pojo.domain.UserDO;
import com.secondhand1.pojo.dto.UserDTO;
import com.secondhand1.pojo.dto.UserInfoDTO;
import com.secondhand1.pojo.query.UserQuery;
import com.secondhand1.service.UserService;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Resource;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import com.secondhand1.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 用户管理模块的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtConfig jwtConfig;

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean registerUser(UserDTO userDTO) {
        // 验证用户名是否已存在
        UserDO userDOByUsername = userMapper.selectByUsername(userDTO.getUsername());
        if (userDOByUsername != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 验证邮箱是否已存在
        UserDO userDOByEmail = userMapper.selectByEmail(userDTO.getEmail());
        if (userDOByEmail != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }

        // 加密用户密码
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        // 将用户数据保存到数据库
        UserDO userDO = new UserDO();
        String token = generateLoginToken(userDO);
        System.out.println("注册成功，令牌：" + token);
        userDO.setResetToken(token);
        userDO.setUsername(userDTO.getUsername());
        userDO.setEmail(userDTO.getEmail());
        userDO.setPhone(userDTO.getPhone());
        userDO.setAddress(userDTO.getAddress());
        userDO.setPasswordHash(encodedPassword);
        userDO.setStatus("active");
        userDO.setCreateTime(new Date());
        // 假设当前用户ID为1
//        userDO.setCreateBy(1);
        int result = userMapper.insert(userDO);
        return result > 0;
    }

    @Override
    public String loginUser(UserQuery userQuery) {
        // 验证用户名或邮箱与密码是否匹配
        UserDO userDO = userMapper.selectByUsernameOrEmail(userQuery.getUsername());
        if (userDO == null || !passwordEncoder.matches(userQuery.getPassword(), userDO.getPasswordHash())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查用户状态是否为active
        if (!"active".equals(userDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 生成登录令牌
        String token = generateLoginToken(userDO);
        System.out.println("登录成功，登录令牌：" + token);
        return token;
//        return ResponseEntity.ok(new UserVO(token));
    }

    @Override
    public Boolean forgetPassword(UserQuery userQuery) {
        // 验证用户是否存在
        UserDO userDO = userMapper.selectByUsernameOrEmail(userQuery.getUsername());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查用户状态是否为active
        if (!"active".equals(userDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 生成重置密码令牌
        String resetToken = generateResetToken(userDO);
        userDO.setResetToken(resetToken);
        System.out.println("重置密码成功，重置令牌：" + resetToken);
        return true;
    }

    @Override
    public Boolean resetPassword1(UserQuery userQuery) {
        // 验证重置密码令牌是否有效
        UserDO userDO = userMapper.selectByResetToken(userQuery.getResetToken());
        if (userDO == null || !isResetTokenValid(userDO, userQuery.getResetToken())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 加密新密码
        String encodedPassword = passwordEncoder.encode(userQuery.getPassword());
        // 更新用户密码
        userDO.setPasswordHash(encodedPassword);
        userDO.setUpdateTime(new Date());
        // 假设当前用户ID为1
//        userDO.setUpdateBy(1);
        int result = userMapper.updateById(userDO);
        System.out.println("重置密码成功，新密码：" + userQuery.getPassword());
        return result > 0;
    }

    @Override
    public UserInfoDTO getUserInfo(UserInfoDTO userInfoDTO) {
        UserDO userDO = userMapper.selectByUsername(userInfoDTO.getUsername());
        if (userDO != null) {
            userInfoDTO.setUserId(userDO.getUserId());
            userInfoDTO.setUsername(userDO.getUsername());
            userInfoDTO.setEmail(userDO.getEmail());
            userInfoDTO.setPhone(userDO.getPhone());
            userInfoDTO.setAddress(userDO.getAddress());
            userInfoDTO.setStatus(userDO.getStatus());
            userInfoDTO.setCreateBy(userDO.getCreateBy());
            userInfoDTO.setCreateTime(userDO.getCreateTime());
        }
        System.out.println("获取用户信息成功：" + userInfoDTO);

        return userInfoDTO;
    }


    private String generateLoginToken(UserDO userDO) {
        // 设置JWT的过期时间为1小时
        long expirationTime = 3600000L; // 1小时
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        // 使用JWT生成登录令牌
        return Jwts.builder()
                .setSubject(userDO.getUsername()) // 用户名作为主题
                .claim("userId", userDO.getUserId()) // 添加用户ID作为自定义声明
                .setIssuedAt(now) // 签发时间
                .setExpiration(expiryDate) // 过期时间
                .signWith(jwtConfig.getSecret()) // 使用密钥签名
                .compact();
    }

    private String generateResetToken(UserDO userDO) {
        // 实现生成重置密码令牌的逻辑
        String token = userDO.getUsername() + System.currentTimeMillis();
        userDO.setResetToken(token);
        userMapper.updateById(userDO);
        return token;
    }

    private Boolean isResetTokenValid(UserDO userDO, String resetToken) {
        // 实现检查重置密码令牌是否有效的逻辑
        return true;
    }

//    private void sendResetPasswordNotification(UserDO userDO, String resetToken) throws MessagingException {
//        // 实现发送邮件或短信的逻辑
//        org.springframework.mail.SimpleMailMessage message = new org.springframework.mail.SimpleMailMessage();
//        message.setTo(userDO.getEmail());
//        message.setSubject("重置密码");
//        message.setText("请使用以下链接重置密码: http://example.com/reset?token=" + resetToken);
//        mailSender.send(message);
//    }
}
