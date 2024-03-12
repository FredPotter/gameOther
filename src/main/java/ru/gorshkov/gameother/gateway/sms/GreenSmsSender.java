package ru.gorshkov.gameother.gateway.sms;

import io.jsonwebtoken.Jwts;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class GreenSmsSender extends AbstractSmsSender{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String sendSms(String phoneNumber, String message) {
        //System.out.println(user + " " + password);
        String url = "https://api3.greensms.ru/sms/send";
        System.out.println("222222222222222222222222222222222222222");
        HttpHeaders headers = new HttpHeaders();
        System.out.println("3333333333333333333333333333333333333333333333");
        headers.set("Authorization", "Bearer " + token); //TODO: Caching token
        System.out.println("444444444444444444444444444444444444444444444");
        SmsRequest smsRequest = SmsRequest.builder().
                to(phoneNumber).txt(message).build();
        System.out.println("5555555555555555555555555555555555555555555555");
        HttpEntity<SmsRequest> request = new HttpEntity<>(smsRequest, headers);
        System.out.println("6666666666666666666666666666666666666666666666666");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("777777777777777777777777777777777777777777777777");
        return response.getBody();
    }

//    private String getToken() {
//        return Jwts.builder()
//                .claims(Map.of("user", ))
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + expiringTime * 10L))
//                .issuer("https://othergame.ru")
//                .signWith(getSigningKey(), Jwts.SIG.HS256)
//                .compact();
//    }
//    private SecretKey getSigningKey() {
//        return new SecretKeySpec(
//                Base64.getEncoder().encode(password.getBytes()),
//                "HmacSHA256");
//    }

    @Builder
    static class SmsRequest {
        private String to;
        private String txt;
    }

}
