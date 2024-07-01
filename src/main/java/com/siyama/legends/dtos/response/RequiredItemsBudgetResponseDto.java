package com.siyama.legends.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RequiredItemsBudgetResponseDto {
    private List<RequiredItemResponseDto> items;
    private String eventId;
    private Integer totalItems;
    private BigDecimal estimatedTotalCost = BigDecimal.valueOf(0);
}
