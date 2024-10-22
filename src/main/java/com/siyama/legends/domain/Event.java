package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class Event extends ParentDomain {
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer expectedPeople;
    private String location;
}
