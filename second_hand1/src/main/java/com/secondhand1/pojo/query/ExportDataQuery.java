package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 导出数据查询对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ExportDataQuery {

    /**
     * 商家ID: 商家ID
     */
    @NotNull(groups = { QueryGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID: 商家ID")
    private Integer merchantId;
}
