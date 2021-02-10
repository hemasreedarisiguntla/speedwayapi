package com.speedwaytrails.speedwayapi.service;

import com.speedwaytrails.speedwayapi.entity.RaceCar;
import com.speedwaytrails.speedwayapi.repository.RaceCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeedWayService {

    private RaceCarRepository raceCarRepository;

    public SpeedWayService(RaceCarRepository raceCarRepository) {
        this.raceCarRepository = raceCarRepository;
    }

    //Browse the racecars to get details about them.
    public List<RaceCar> getAllRaceCars() {
        return raceCarRepository.findAll();
    }
}
