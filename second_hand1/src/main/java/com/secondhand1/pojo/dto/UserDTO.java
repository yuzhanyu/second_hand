package com.secondhand1.pojo.dto;

import javax.validation.constraints.Pattern;

import com.secondhand1.pojo.query.QueryGroup;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotBlank;

/**
 * 用户注册信息
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class UserDTO {

    /**
     * 用户名，必填
     */
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名，必填")
    private String username;

    /**
     * 邮箱，必填
     */
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "邮箱不能为空")
    @Email(groups = { CreateGroup.class, QueryGroup.class }, message = "邮箱格式错误")
    @Schema(description = "邮箱，必填")
    private String email;

    /**
     * 电话号码
     */
    @Pattern(groups = { CreateGroup.class, QueryGroup.class }, regexp = "^\\d{10}$", message = "电话号码格式错误")
    @Schema(description = "电话号码")
    private String phone;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * 密码，必填
     */
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "密码不能为空")
    @Schema(description = "密码，必填")
    private String password;

    /**
     * 重置密码令牌，必填
     */
    @NotNull(groups = QueryGroup.class, message = "重置密码令牌不能为空")
    @Schema(description = "重置密码令牌")
    private String resetToken;

    /**
     * 新密码，必填
     */
    @NotNull(groups = QueryGroup.class, message = "新密码不能为空")
    @Schema(description = "新密码，必填")
    private String newPassword;

    /**
     * 用户ID:必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;
}
