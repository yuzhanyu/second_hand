package com.secondhand1.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 系统日志实体类
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDO {

    /**
     * 日志ID:日志ID
     */
    @Schema(description = "日志ID:日志ID")
    private Integer logId;

    /**
     * 用户ID:用户ID
     */
    @Schema(description = "用户ID:用户ID")
    private Integer userId;

    /**
     * 商家ID:商家ID
     */
    @Schema(description = "商家ID:商家ID")
    private Integer merchantId;

    /**
     * 操作行为:操作行为
     */
    @Schema(description = "操作行为:操作行为")
    private String action;

    /**
     * 操作详情:操作详情
     */
    @Schema(description = "操作详情:操作详情")
    private String details;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private Date createTime;
}
