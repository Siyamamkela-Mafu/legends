package com.siyama.legends.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class RequiredItem extends ParentDomain {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private BigDecimal unitPrice;
    @NotNull
    @NotEmpty
    private Integer quantity;
    @NotNull
    @NotEmpty
    private String eventId;
}
