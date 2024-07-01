package com.siyama.legends.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredItemRequestDto {
    @Schema(example = "Potato")
    private String name;
    @Schema(example = "19.99", description = "The current currency is in ZAR")
    private BigDecimal unitPrice;
    @Schema(example = "1")
    private Integer quantity;
}
