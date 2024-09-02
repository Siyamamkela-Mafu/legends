package com.siyama.legends.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
public class ParentDomain {
    @MongoId
    public String id;
}
