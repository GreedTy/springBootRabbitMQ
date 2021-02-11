package com.spring.rabbitmq.alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfig {

    @Value("${TEST.SCHEDULE}")
    private String scheduleString;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 18000, initialDelay = 10000)
    public void schedulePrint() {
        logger.debug("{}-{}",System.currentTimeMillis(), scheduleString);
    }

}
