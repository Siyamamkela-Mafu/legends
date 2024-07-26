package com.siyama.legends.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.siyama.legends.domain.NotificationMessage;

public interface FirebaseMessagingService {
    void sendMessage(NotificationMessage notificationMessage) throws FirebaseMessagingException;
}
