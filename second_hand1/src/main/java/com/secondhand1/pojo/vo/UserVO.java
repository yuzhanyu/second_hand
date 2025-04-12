package com.secondhand1.pojo.vo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户视图对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer id;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

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
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
    /**
     * 令牌
     */
    @Schema(description = "令牌")
    private String token;

    public UserVO(String token) {
        this.token = token;
    }
}
