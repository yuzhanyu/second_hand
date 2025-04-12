package com.secondhand1.pojo.domain;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 商品分类信息实体类
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDO {


    /**
     * 分类ID:分类ID
     */
    @Schema(description = "分类ID:分类ID")
    private Integer categoryId;
    /**
     * 商家ID:商家ID
     */
    @Schema(description = "商家ID:商家ID")
    private Integer merchantId;

    /**
     * 分类名称:分类名称
     */
    @Schema(description = "分类名称:分类名称")
    private String name;

    /**
     * 分类描述:分类描述
     */
    @Schema(description = "分类描述:分类描述")
    private String description;

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private Integer createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private java.util.Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private Integer updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private java.util.Date updateTime;
}
