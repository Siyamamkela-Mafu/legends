package com.siyama.legends.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class Organisation extends ParentDomain {
    private String name;
    private Boolean isActive;
}
