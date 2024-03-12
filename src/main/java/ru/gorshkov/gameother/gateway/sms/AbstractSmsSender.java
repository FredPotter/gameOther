package ru.gorshkov.gameother.gateway.sms;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractSmsSender {
    public abstract String sendSms(String phoneNumber, String message);
}
