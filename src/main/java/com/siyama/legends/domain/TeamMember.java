package com.siyama.legends.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Document
public class TeamMember extends ParentDomain {
    private String name;
    private String surname;
    private String contactNo;
    private String email;
    private String roles;
    private String teamId;
    private Boolean isActive;
}
