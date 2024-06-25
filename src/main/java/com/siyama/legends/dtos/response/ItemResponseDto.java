package com.siyama.legends.dtos.response;

import com.siyama.legends.domain.IdentifiableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ItemResponseDto extends IdentifiableDto {
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
    private String eventId;
}
