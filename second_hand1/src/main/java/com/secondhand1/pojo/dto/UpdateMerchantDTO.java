package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author hanghang
 * @date 2025/3/23
 * @Description
 */
@Data
public class UpdateMerchantDTO {
    /**
     * 商家ID:商家ID，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID:商家ID，必填")
    private Integer merchantId;

    /**
     * 用户名:用户名，必填
     */
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名:用户名，必填")
    private String username;

    /**
     * 邮箱:邮箱，必填
     */
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "邮箱不能为空")
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

    /**
     * 商家状态:商家状态
     */
    @Schema(description = "商家状态:商家状态")
    private String status;
}
