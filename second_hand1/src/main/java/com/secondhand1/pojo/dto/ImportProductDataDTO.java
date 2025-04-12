package com.secondhand1.pojo.dto;

import java.util.List;
import com.secondhand1.pojo.domain.ProductDO;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 导入商品数据对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ImportProductDataDTO {

    /**
     * 商家ID: 商家ID
     */
    @NotNull(groups = { CreateGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID: 商家ID")
    private Integer merchantId;

    /**
     * 商品列表: 商品列表
     */
//    @NotNull(groups = { CreateGroup.class }, message = "商品列表不能为空")
//    @Schema(description = "商品列表: 商品列表")
    private List<ProductDO> products;
}
