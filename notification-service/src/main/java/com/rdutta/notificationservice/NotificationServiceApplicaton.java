package com.rdutta.notificationservice;

import com.rdutta.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplicaton.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        //send out the email notification
        log.info("Received notification for the Order - {} ",orderPlacedEvent.getOrderNumber());
    }
}