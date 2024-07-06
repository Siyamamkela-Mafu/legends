package com.siyama.legends.dtos.request;

import com.siyama.legends.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationRequestDto {
    @Schema(example = "Triangle")
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "name must contain only letters and numbers")
    public String name;
}
