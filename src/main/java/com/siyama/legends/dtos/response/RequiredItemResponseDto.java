package com.siyama.legends.dtos.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredItemResponseDto extends ParentDto {
    private String name;
    private BigDecimal unitPrice;
    private Integer quantity;
    private List<TeamMemberResponseDto> teamMembers;
}
