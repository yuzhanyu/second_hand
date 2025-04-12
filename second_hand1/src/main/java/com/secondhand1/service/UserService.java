package com.secondhand1.service;

import com.secondhand1.pojo.dto.UserDTO;
import com.secondhand1.pojo.dto.UserInfoDTO;
import com.secondhand1.pojo.query.UserQuery;
import java.lang.Boolean;
import java.lang.String;

/**
 * 用户管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userDTO 用户注册信息
     * @return
     */
    Boolean registerUser(UserDTO userDTO);

    /**
     * 用户登录
     *
     * @param userQuery 用户查询信息
     * @return
     */
    String loginUser(UserQuery userQuery);

    /**
     * 忘记密码
     *
     * @param userQuery 用户查询信息
     * @return
     */
    Boolean forgetPassword(UserQuery userQuery);

    /**
     * 重置密码
     *
     * @param userQuery 用户查询信息
     * @return
     */
    Boolean resetPassword1(UserQuery userQuery);

    //根据username查询用户信息
    UserInfoDTO getUserInfo(UserInfoDTO userInfoDTO);

}
