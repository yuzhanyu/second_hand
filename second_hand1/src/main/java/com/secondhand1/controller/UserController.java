package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.dto.UserDTO;
import com.secondhand1.pojo.dto.UserInfoDTO;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.pojo.query.UserQuery;
import com.secondhand1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "用户管理模块")
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userDTO 用户注册信息
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "用户注册")
    @ResponseBody
    public RestResult<Boolean> registerUser(@RequestBody @Validated(CreateGroup.class) UserDTO userDTO) {
        Boolean result = userService.registerUser(userDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 用户登录
     *
     * @param userQuery 用户查询信息
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "用户登录")
    @ResponseBody
    public RestResult<String> loginUser(@RequestBody @Validated(QueryGroup.class) UserQuery userQuery) {
        String result = userService.loginUser(userQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 忘记密码
     *
     * @param userQuery 用户查询信息
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    @Operation(summary = "忘记密码")
    @ResponseBody
    public RestResult<Boolean> forgetPassword(@RequestBody @Validated(QueryGroup.class) UserQuery userQuery) {
        Boolean result = userService.forgetPassword(userQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 重置密码
     *
     * @param userQuery 用户查询信息
     * @return
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @Operation(summary = "重置密码")
    @ResponseBody
    public RestResult<Boolean> resetPassword1(@RequestBody @Validated(QueryGroup.class) UserQuery userQuery) {
        Boolean result = userService.resetPassword1(userQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
    /**
     * 通过获取用户信息
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @Operation(summary = "获取用户信息")
    public RestResult<UserInfoDTO> getUserInfo(@RequestBody @Validated(QueryGroup.class) UserInfoDTO userInfoDTO) {
        UserInfoDTO userInfo = userService.getUserInfo(userInfoDTO);

        if (userInfo == null) {
            return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, userInfo);
        }

        return ResponseEntity.ok(new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, userInfo)).getBody();
    }



}
