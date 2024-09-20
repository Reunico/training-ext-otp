package com.trainings.otp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@Getter
@Setter
public class ApplicationProperties {

    private String login;
    private String password;
    private String lotteryUrl;
    private String participantUrl;
    private String numberingUrl;
    private String notificationUrl;

}
