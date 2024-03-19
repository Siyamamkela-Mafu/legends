package com.siyama.legends.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitteeMemberRequestDto {
    @Schema(example = "Anga Jackal",
            description = "The name and surname or just a name only.")
    private String name;
    @Schema(example = "01234567899")
    private String contactNo;
    @Schema(example = "Treasurer")
    private String role;
}
