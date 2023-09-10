package org.gdas.bigreportsworker.listener;

import org.gdas.bigreportsworker.service.ReportService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReportsRequestsListener {

    private final ReportService reportService;

    public ReportsRequestsListener(ReportService reportService) {
        this.reportService = reportService;
    }

    @KafkaListener(
            topics = "${kafka.reports.topic}",
            groupId = "${kafka.group}"
    )
    void listener(String message) {
        reportService.produce(message);
    }
}
