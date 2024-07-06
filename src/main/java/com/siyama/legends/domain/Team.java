package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class Team extends ParentDomain {
    private String name;
    private String organisationId;
    private Boolean isActive;
}
