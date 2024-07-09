package com.siyama.legends.dtos.response;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberResponseDto{
    private String id;
    private String name;
    private String surname;
}
