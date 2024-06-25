package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Builder
@Data
@Document
public class RequiredItem {
    @MongoId
    private String Id;
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
    private String eventId;
}
