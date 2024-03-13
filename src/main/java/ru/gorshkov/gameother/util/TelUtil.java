package ru.gorshkov.gameother.util;

import org.springframework.web.client.RestTemplate;
import ru.gorshkov.gameother.gateway.sms.AbstractSmsSender;
import ru.gorshkov.gameother.gateway.sms.GreenSmsSender;
import ru.gorshkov.gameother.gateway.sms.TwilioSmsSender;

public class TelUtil {
    public static int generateCode() {
        return (int) ((Math.random() * 100000) % 10000);
    }
    public static AbstractSmsSender getSmsSender(String phoneNumberRegion) {
        switch (phoneNumberRegion) {
            case "7" -> {return new GreenSmsSender();}
            case "1" -> {return new TwilioSmsSender();}

        }
        return new GreenSmsSender();
    }
}
