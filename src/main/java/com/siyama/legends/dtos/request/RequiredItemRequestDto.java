package com.siyama.legends.dtos.request;

import com.siyama.legends.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredItemRequestDto {
    @Schema(example = "Potato")
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Size(min = 2, message = "name length should be at least two characters")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "name must contain only letters")
    private String name;

    @Schema(example = "19.99", description = "The current currency is in ZAR")
    @NotNull(message = "unitPrice is required")
    @Min(value = 0, message = "unitPrice cannot be less than 0")
    private BigDecimal unitPrice;

    @Schema(example = "1")
    @NotNull(message = "quantity is required")
    @Min(value = 1, message = "quantity cannot be zero or less")
    private Integer quantity;
}
