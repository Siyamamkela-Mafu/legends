package com.siyama.legends.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ItemsBudgetResponseDto {
    private List<ItemResponseDto> items;
    private BigDecimal totalItems;
    private BigDecimal estimatedTotalCost;
}
