package com.siyama.legends.dtos.response;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredItemResponseDto extends ParentDto {
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
}
