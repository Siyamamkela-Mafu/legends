package com.siyama.legends.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {
    private String eventName;
    private Date startDate;
    private Date endDate;
    private Integer expectedPeople;
    private String locationId;
}
