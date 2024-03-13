package ru.gorshkov.gameother.gateway.sms;

public abstract class AbstractSmsSender {
    public abstract String sendSms(String phoneNumber, String message);
    protected abstract Object getToken();
}
