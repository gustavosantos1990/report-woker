package org.gdas.bigreportsworker.listener;

import org.gdas.bigreportsworker.model.entity.AnyEntity;
import org.gdas.bigreportsworker.service.AnyService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReportsRequestsListener {

    private final AnyService anyService;

    public ReportsRequestsListener(AnyService anyService) {
        this.anyService = anyService;
    }

    @KafkaListener(
            topics = "${kafka.reports.topic}",
            groupId = "${kafka.group}"
    )
    void listener(String message) {
        AnyEntity saved = anyService.save(message);
        System.out.println(saved);
    }
}
