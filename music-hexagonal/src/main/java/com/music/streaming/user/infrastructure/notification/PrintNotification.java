package com.music.streaming.user.infrastructure.notification;

import com.music.streaming.user.application.port.NotificationService;

public class PrintNotification implements NotificationService {

    @Override
    public void sendAlert(String message) {
        System.out.println(message);
    }
}
