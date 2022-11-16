package com.formation.velo.task;

import com.formation.velo.service.PoolService;
import com.formation.velo.service.StationService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log
public class ScheduledTask {

    private final StationService stationService;
    private final PoolService poolService;

    public ScheduledTask(StationService stationService, PoolService poolService){

        this.stationService=stationService;
        this.poolService=poolService;
    }

    @Scheduled(fixedRate = 60000) //1min
    public void searchNextMatchByCompetition(){
        stationService.saveRecord();
        poolService.saveRecord();
    }

}
