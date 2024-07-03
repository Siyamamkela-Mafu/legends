package com.siyama.legends.dtos.request;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitteeMemberRequestDto {
    @Valid
    @Schema(example = "Anga Jackal",
            description = "The name and surname or just a name only.")
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Pattern(regexp = Constants.SPECIAL_CHARACTERS_PATTERN, message = "name must contain only letters")
    private String name;

    @Schema(example = "01234567899")
    @Size(min = 10, max = 10, message = "contactNo must be 10 digits")
    @NotNull(message = "contactNo is required")
    @NotEmpty(message = "contactNo is required")
    private String contactNo;

    @Schema(example = "Treasurer")
    @NotNull(message = "role is required")
    @NotEmpty(message = "role is required")
    private String role;
}
