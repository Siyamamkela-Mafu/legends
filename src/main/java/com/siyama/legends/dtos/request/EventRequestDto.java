package com.siyama.legends.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {
    @Schema(example = "Gala dinner")
    private String eventName;
    @Schema(example = "12-12-2024",
            description = "The format must be DD-MM-YYY")
    private Date startDate;
    @Schema(example = "14-12-2024",
            description = "The format must be DD-MM-YYY")
    private Date endDate;
    @Schema(example = "1")
    private Integer expectedPeople;
    @Schema(example = "Gqeberha")
    private String location;
}
