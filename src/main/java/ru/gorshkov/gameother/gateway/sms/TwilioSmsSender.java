package ru.gorshkov.gameother.gateway.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSender extends AbstractSmsSender{
    @Value("${twilio.account_sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;

    @Override
    public String sendSms(String phoneNumber, String message) {
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         return Message.creator(new PhoneNumber(phoneNumber),
             new PhoneNumber("+15109076591"), message
        ).create().getBody();
    }
}
