package com.siyama.legends.dtos.messaging;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class EmailMessageDto {
    private String toEmail;
    private String subject;
    private String body;
    private String additionalInfo;
}
