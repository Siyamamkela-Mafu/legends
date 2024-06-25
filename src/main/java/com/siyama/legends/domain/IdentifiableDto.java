package com.siyama.legends.domain;


import org.springframework.data.mongodb.core.mapping.MongoId;

public class IdentifiableDto {
    @MongoId
    public String id;
}
