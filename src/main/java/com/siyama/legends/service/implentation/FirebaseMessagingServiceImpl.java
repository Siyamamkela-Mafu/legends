package com.siyama.legends.service.implentation;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.siyama.legends.domain.NotificationMessage;
import com.siyama.legends.service.FirebaseMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirebaseMessagingServiceImpl implements FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    @Override
    public void sendMessage(NotificationMessage notificationMessage) throws FirebaseMessagingException {
       Notification notification = Notification.builder()
               .setTitle(notificationMessage.getTitle())
               .setBody(notificationMessage.getBody())
               .build();

        Message message = Message.builder()
                .setToken(notificationMessage.getRecipientToken())
                .setNotification(notification)
                .build();

            firebaseMessaging.send(message);
    }
}
