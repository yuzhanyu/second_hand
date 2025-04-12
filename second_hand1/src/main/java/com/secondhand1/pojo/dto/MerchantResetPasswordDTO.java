package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商家重置密码入参实体
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class MerchantResetPasswordDTO {

    /**
     * 重置令牌:重置令牌，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "重置令牌不能为空")
    @Schema(description = "重置令牌:重置令牌，必填")
    private String token;

    /**
     * 新密码:新密码，必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "新密码不能为空")
    @Schema(description = "新密码:新密码，必填")
    private String newPassword;
}
