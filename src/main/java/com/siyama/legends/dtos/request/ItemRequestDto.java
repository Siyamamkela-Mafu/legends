package com.siyama.legends.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
}
