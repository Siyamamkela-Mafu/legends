package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class RequiredItem extends IdentifiableDto {
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
    private String eventId;
}
