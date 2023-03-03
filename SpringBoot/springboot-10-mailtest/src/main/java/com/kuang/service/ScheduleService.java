package com.kuang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("定时任务执行了");
    }
}
