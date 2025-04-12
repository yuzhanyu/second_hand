package com.secondhand1.pojo.query;

import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户查询信息
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class UserQuery {

    /**
     * 用户名或邮箱，必填
     */
    @NotNull(groups = QueryGroup.class, message = "用户名或邮箱不能为空")
    @Schema(description = "用户名或邮箱，必填")
    private String username;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 重置密码令牌，必填
     */
    @NotNull(groups = QueryGroup.class, message = "重置密码令牌不能为空")
    @Schema(description = "重置密码令牌，必填")
    private String resetToken;

    /**
     * 新密码，必填
     */
    @NotNull(groups = QueryGroup.class, message = "新密码不能为空")
    @Schema(description = "新密码，必填")
    private String password;

    /**
     * 当前页码
     */
    @Schema(description = "当前页码")
    private Integer pageIndex;

    /**
     * 每页记录数
     */
    @Schema(description = "每页记录数")
    private Integer pageSize;
}
