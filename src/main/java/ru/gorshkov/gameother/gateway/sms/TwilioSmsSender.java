package ru.gorshkov.gameother.gateway.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import ru.gorshkov.gameother.util.PropertyReader;

public class TwilioSmsSender extends AbstractSmsSender{
    private final String ACCOUNT_SID;
    private final String AUTH_TOKEN;

    public TwilioSmsSender() {
        PropertyReader propertyReader = new PropertyReader("security.txt");
        ACCOUNT_SID = propertyReader.getProperty("twilio.account_sid");
        AUTH_TOKEN = propertyReader.getProperty("twilio.auth_token");
    }

    @Override
    public String sendSms(String phoneNumber, String message) {
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         return Message.creator(new PhoneNumber(phoneNumber),
             new PhoneNumber("+15109076591"), message
        ).create().getBody();
    }

    @Override
    protected Object getToken() {
        return AUTH_TOKEN;
    }
}
