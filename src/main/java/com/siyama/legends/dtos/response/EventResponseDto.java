package com.siyama.legends.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDto {
    private String id;
    private String name;
    private LocationResponseDto location;
    private CommitteeResponseDto committee;
    private Integer couponsSold;
    private Integer couponsBought;
    private BigDecimal totalOrganisingCost;
}
