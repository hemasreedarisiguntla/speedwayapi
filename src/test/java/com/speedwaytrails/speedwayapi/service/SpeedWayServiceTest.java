package com.speedwaytrails.speedwayapi.service;

import com.speedwaytrails.speedwayapi.entity.Driver;
import com.speedwaytrails.speedwayapi.entity.RaceCar;
import com.speedwaytrails.speedwayapi.repository.RaceCarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpeedWayServiceTest {

    SpeedWayService speedWayService;
    RaceCarRepository raceCarRepository;

    @BeforeEach
    void setUp() {
        raceCarRepository = mock(RaceCarRepository.class);
        speedWayService = new SpeedWayService(raceCarRepository);
    }


    @Test
    public void getAllRaceCars() {

        List<RaceCar> expectedRaceCars = setUpRaceCarData();

        when(raceCarRepository.findAll()).thenReturn(expectedRaceCars);

        List<RaceCar> actualRaceCars = speedWayService.getAllRaceCars();

        assertEquals(expectedRaceCars, actualRaceCars);
        assertEquals(expectedRaceCars.size(), actualRaceCars.size());

    }

    private List<RaceCar> setUpRaceCarData() {
        ArrayList<Driver> driverList = new ArrayList<>();
        Driver driver = Driver.builder()
                .first_name("abc")
                .last_name("xyz")
                .age(27).nickname("a").wins(2).losses(1).build();
        driverList.add(driver);

        List<RaceCar> raceCars = new ArrayList<>();
        RaceCar raceCar = RaceCar.builder().nickname("The Condor")
                .model("Corvette")
                .year("2019")
                .status("AVAILABLE")
                .top_speed(189)
                .type("sports")
                .driverList(driverList)
                .build();

        raceCars.add(raceCar);
        return raceCars;
    }


}
