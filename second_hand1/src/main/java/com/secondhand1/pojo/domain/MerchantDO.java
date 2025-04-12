package com.secondhand1.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商家实体类
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDO {



    /**
     * 用户名:用户名
     */
    @Schema(description = "用户名:用户名")
    private String username;

    /**
     * 密码哈希值:密码哈希值
     */
    @Schema(description = "密码哈希值:密码哈希值")
    private String passwordHash;

    /**
     * 邮箱:邮箱
     */
    @Schema(description = "邮箱:邮箱")
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

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private Integer createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private Integer updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private Date updateTime;

    /**
     * 重置令牌:重置令牌
     */
    @Schema(description = "重置令牌:重置令牌")
    private String resetToken;

    /**
     * 商家ID:商家ID
     */
    @Schema(description = "商家ID:商家ID")
    private Integer merchantId;
}
