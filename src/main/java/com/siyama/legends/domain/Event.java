package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class Event extends IdentifiableDto {
    private String eventName;
    private Date startDate;
    private Date endDate;
    private Integer expectedPeople;
    private String location;
}
