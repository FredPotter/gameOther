package ru.gorshkov.gameother.gateway.sms;

import lombok.Builder;
import org.springframework.http.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gorshkov.gameother.DTO.requests.GreenSmsGetTokenRequest;
import ru.gorshkov.gameother.DTO.responses.GreenSmsGetTokenResponse;
import ru.gorshkov.gameother.util.PropertyReader;
import java.util.Map;

public class GreenSmsSender extends AbstractSmsSender {
    private final PropertyReader propertyReader = new PropertyReader("security.txt");

    private final GreenSmsGetTokenRequest greenSmsGetTokenRequest
            = new GreenSmsGetTokenRequest(
            propertyReader.getProperty("greensms.username"),
            propertyReader.getProperty("greensms.password"),
            Long.parseLong(propertyReader.getProperty("greensms.expiringTime")) +
                    System.currentTimeMillis()
    );

    @Override
    public String sendSms(String phoneNumber, String message) {
        String url = "https://api3.greensms.ru/sms/send";

        WebClient client = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getToken().getAccess_token())
                .build();
        return client.post()
                .body(BodyInserters.fromValue(Map.of("to", phoneNumber, "txt", message))
                ).retrieve().bodyToMono(String.class).block();
    }

    protected GreenSmsGetTokenResponse getToken() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api3.greensms.ru/account/token")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return client.post()
                .body(BodyInserters.fromValue(greenSmsGetTokenRequest))
                .retrieve()
                .bodyToMono(GreenSmsGetTokenResponse.class)
                .block();
    }

    @Builder
    static class SmsRequest {
        private String to;
        private String txt;
    }

}
