package com.siyama.legends.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.siyama.legends.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {
    @Valid
    @Schema(example = "Gala dinner")
    @NotNull(message = "eventName is required")
    @NotEmpty(message = "eventName is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "eventName must contain only letters and numbers")
    private String eventName;

    @Schema(example = "12-12-2024",
            description = "The format must be DD-MM-YYY")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate is required")
    @NotEmpty(message = "startDate is required")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;

    @Schema(example = "14-12-2024",
            description = "The format must be DD-MM-YYY")
    @JsonFormat(pattern = "dd-MM-yyyy")

    @NotNull(message = "endDate is required")
    @NotEmpty(message = "endDate is required")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;

    @Schema(example = "1")
    @NotNull(message = "expectedPeople is required")
    @NotEmpty(message = "expectedPeople is required")
    @Size(min = 1, max = 999999999, message = "expectedPeople cannot be less than 1")
    private Integer expectedPeople;

    @Schema(example = "Gqeberha")
    @NotNull(message = "location is required")
    @NotEmpty(message = "location is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "location must contain only letters and numbers")
    private String location;
}
