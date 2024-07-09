package com.siyama.legends.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siyama.legends.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberRequestDto {
    @Schema(example = "Joe")
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    @Pattern(regexp = Constants.ONLY_LETTERS_WITH_HYPHEN,
            message = "name must contain only letters(hyphen allowed)")
    private String name;
    @Schema(example = "Soap")
    @NotNull(message = "surname is required")
    @NotEmpty(message = "surname is required")
    @Pattern(regexp = Constants.ONLY_LETTERS_WITH_HYPHEN,
            message = "surname must contain only letters(hyphen allowed)")
    private String surname;
    @Schema(example = "01234567890")
    @NotNull(message = "contactNo is required")
    @NotEmpty(message = "contactNo is required")
    @Pattern(regexp = Constants.ONLY_NUMBERS,
            message = "contactNo must contain only numbers")
    private String contactNo;
    @Schema(example = "test@test.com")
    @Pattern(regexp = Constants.EMAIL_COMPLIANT_FORMAT,
            message = "email must contain @ and .")
    private String email;
    private String[] role;
    @JsonIgnore
    private String teamId;
}