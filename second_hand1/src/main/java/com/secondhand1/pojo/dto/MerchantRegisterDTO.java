package com.secondhand1.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商家注册入参实体
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class MerchantRegisterDTO {

    /**
     * 用户名:用户名，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名:用户名，必填")
    private String username;

    /**
     * 密码:密码，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "密码不能为空")
    @Schema(description = "密码:密码，必填")
    private String password;

    /**
     * 邮箱:邮箱，必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "邮箱不能为空")
    @Schema(description = "邮箱:邮箱，必填")
    private String email;

    /**
     * 电话号码:电话号码
     */
    @Schema(description = "电话号码:电话号码")
    private String phone;

    /**
     * 地址:地址
     */
    @Schema(description = "地址:地址")
    private String address;

    /**
     * 店铺名称:店铺名称
     */
    @Schema(description = "店铺名称:店铺名称")
    private String storeName;
}
