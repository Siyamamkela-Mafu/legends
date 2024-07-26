package com.siyama.legends.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class NotificationMessage {
    private String title;
    private String body;
    private String recipientToken;
}
