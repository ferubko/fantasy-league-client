package com.learn.fantasy.service;

import com.learn.fantasy.exception.InternalServiceInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SynchronizeCron {
    @Autowired
    private SynchronizeService synchronizeService;

    //    @Scheduled(cron = "0 59 23 28-31 * ?")
    @Scheduled(cron = "${мissingDataCron:0 59 23 28-31 * ?}")
    public int syncMissingData() throws InternalServiceInvocationException {
        return synchronizeService.executeSyncMissingData();
    }

    //    @Scheduled(cron = "0 59 23 * * TUE,FRI")
    @Scheduled(cron = "${existingDataCron:0 59 23 * * TUE,FRI}")
    public int syncExistingData() throws InternalServiceInvocationException {
        return synchronizeService.executeSyncExistingData();
    }
}
