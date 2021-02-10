package com.speedwaytrails.speedwayapi.service;

import com.speedwaytrails.speedwayapi.entity.Driver;
import com.speedwaytrails.speedwayapi.entity.RaceCar;
import com.speedwaytrails.speedwayapi.repository.RaceCarRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class SpeedWayService {

    private RaceCarRepository raceCarRepository;

    public SpeedWayService(RaceCarRepository raceCarRepository) {
        this.raceCarRepository = raceCarRepository;
    }

    @PostConstruct
    public void init(){
        RaceCar raceCar = RaceCar.builder().nickname("The Condor").model("Corvette").year("2010").status("AVAILABLE").top_speed(189).build();
        Driver driver = Driver.builder().first_name("jack").last_name("dan").age(32).nickname("ja").wins(1).losses(1).build();
        raceCar.getDriverList().add(driver);
        raceCarRepository.save(raceCar);

    }

    //Browse the racecars to get details about them.
    public List<RaceCar> getAllRaceCars() {
        return raceCarRepository.findAll();
    }
}
