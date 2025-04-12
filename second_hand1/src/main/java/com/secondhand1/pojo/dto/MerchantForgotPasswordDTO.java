package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商家忘记密码入参实体
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class MerchantForgotPasswordDTO {

    /**
     * 用户名或邮箱:用户名或邮箱，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "用户名或邮箱不能为空")
    @Schema(description = "用户名或邮箱:用户名或邮箱，必填")
    private String usernameOrEmail;
}
