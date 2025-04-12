package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author hanghang
 * @date 2025/3/23
 * @Description
 */
@Data
public class UpdateUserDTO {
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
    @Schema(description = "用户状态")
    private String status;


    /**
     * 用户ID:必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;
}
