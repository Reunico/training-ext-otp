package com.trainings.otp.service;

import com.trainings.otp.config.ApplicationProperties;
import com.trainings.otp.model.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final ApplicationProperties applicationProperties;
    private final RestTemplate restTemplate;

    public NotificationServiceImpl(ApplicationProperties applicationProperties, @Qualifier("authenticatedTemplate") RestTemplate restTemplate) {
        this.applicationProperties = applicationProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public void notify(Number chatId, String message) {
        restTemplate.postForLocation(applicationProperties.getNotificationUrl(), new Notification(chatId, message));
    }
}
