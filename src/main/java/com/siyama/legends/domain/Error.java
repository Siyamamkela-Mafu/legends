package com.siyama.legends.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error {
    private String statusCode;
    private String message;
    private Integer retryAfter;
}
