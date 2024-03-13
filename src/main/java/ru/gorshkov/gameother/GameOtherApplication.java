package ru.gorshkov.gameother;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gorshkov.gameother.gateway.sms.GreenSmsSender;

@SpringBootApplication
public class GameOtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameOtherApplication.class, args);
    }

}
