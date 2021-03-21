package com.spring.rabbitmq.alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerPrint {

    @Value("${TEST.SCHEDULE}")
    private String scheduleString;

    @Scheduled(fixedRate = 10000, initialDelay = 1000)
    public void schedulePrint() {
        System.out.println(scheduleString);
    }

}
