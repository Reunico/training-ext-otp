package com.trainings.otp.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {

    private Number chatId;
    private String text;

}
