package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author hanghang
 * @date 2025/3/26
 * @Description
 */
@Data
public class UserInfoDTO {
    @NotBlank(groups = { CreateGroup.class, QueryGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名，必填")
    private String username;

    /**
     * 密码哈希值
     */
    @Schema(description = "密码哈希值")
    private String passwordHash;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 电话号码
     */
    @Schema(description = "电话号码")
    private String phone;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * 用户状态
     */
    @Schema(description = "用户状态")
    private String status;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;

    /**
     * 重置密码令牌
     */
    @Schema(description = "重置密码令牌")
    private String resetToken;

    /**
     * 用户ID:用户ID
     */
    @Schema(description = "用户ID:用户ID")
    private Integer userId;


}
