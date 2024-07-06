package com.siyama.legends.dtos.response;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationResponseDto extends ParentDto {
    public String name;
}
