package com.siyama.legends.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siyama.legends.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {
    @JsonIgnore
    private String organisationId;
    @Schema(example = "Gala dinner")
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "name must contain only letters and numbers")
    private String name;

    @Schema(example = "12-12-2024",
            description = "The format must be DD-MM-YYY")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate is required")
    @FutureOrPresent(message = "startDate must be today or in the future")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @Schema(example = "14-12-2024",
            description = "The format must be DD-MM-YYY")
    @JsonFormat(pattern = "dd-MM-yyyy")

    @NotNull(message = "endDate is required")
    @FutureOrPresent(message = "endDate must be today or in the future")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @Schema(example = "1")
    @NotNull(message = "expectedPeople is required")
    @Min(value = 1, message = "expectedPeople cannot be less than 1")
    private Integer expectedPeople;

    @Schema(example = "Gqeberha")
    @NotNull(message = "location is required")
    @NotEmpty(message = "location is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "location must contain only letters and numbers")
    private String location;
}
