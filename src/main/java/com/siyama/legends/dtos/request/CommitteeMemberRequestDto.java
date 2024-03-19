package com.siyama.legends.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitteeMemberRequestDto {
    private String name;
    private String contactNo;
    private String role;
    private Boolean isActive;
}
