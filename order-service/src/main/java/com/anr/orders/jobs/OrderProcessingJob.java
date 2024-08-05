package com.anr.orders.jobs;

import com.anr.orders.domain.OrderService;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class OrderProcessingJob {

    private final OrderService orderService;

    OrderProcessingJob(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "${orders.new-orders-job-cron}")
    public void processNewOrders() {
        log.info("Processing new orders at {}", Instant.now());
        orderService.processNewOrders();
    }
}
