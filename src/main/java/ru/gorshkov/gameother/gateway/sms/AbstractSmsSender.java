package ru.gorshkov.gameother.gateway.sms;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractSmsSender {
    public abstract String sendSms(String phoneNumber, String message);
    public abstract Object getToken();
}
