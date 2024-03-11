package ru.gorshkov.gameother.gateway;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {
    @Value("${twilio.account_sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;

    public void sendSms(String phone, String code) {
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message.creator(new PhoneNumber(phone),
             new PhoneNumber("+15109076591"),
             code
        ).create();
    }
}
