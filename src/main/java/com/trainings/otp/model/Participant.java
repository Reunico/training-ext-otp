package com.trainings.otp.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Participant {
    private String name;
    private Instant createdDate;
    private Long chatId;
    private Long number;
}
