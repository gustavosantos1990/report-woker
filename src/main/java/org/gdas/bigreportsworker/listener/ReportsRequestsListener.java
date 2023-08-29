package org.gdas.bigreportsworker.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReportsRequestsListener {

    @KafkaListener(
            topics = "big-reports-requests",
            groupId = "groupId"
    )
    void listener(String message) {
        System.out.println("received: " + message);
    }
}
