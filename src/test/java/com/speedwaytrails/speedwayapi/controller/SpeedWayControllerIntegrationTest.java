package com.speedwaytrails.speedwayapi.controller;

import com.speedwaytrails.speedwayapi.entity.Driver;
import com.speedwaytrails.speedwayapi.entity.RaceCar;
import com.speedwaytrails.speedwayapi.repository.RaceCarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpeedWayControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RaceCarRepository raceCarRepository;

    @Test
    public void getAllRaceCars() throws Exception {

        mockMvc.perform(get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.[0].nickname").value("The Condor"))
                .andExpect(jsonPath("$.[0].model").value("Corvette"))
                .andExpect(jsonPath("$.[0].year").value("2010"))
                .andExpect(jsonPath("$.[0].status").value("AVAILABLE"))
                .andExpect(jsonPath("$.[0].top_speed").value(189))
                .andExpect(jsonPath("$.[0].driverList.length()").value(1));

    }


    @BeforeEach
    public void init(){
        RaceCar raceCar = RaceCar.builder().nickname("The Condor").model("Corvette").year("2010").status("AVAILABLE").top_speed(189).build();
        Driver driver = Driver.builder().first_name("jack").last_name("dan").age(32).nickname("ja").wins(1).losses(1).build();
        raceCar.getDriverList().add(driver);
        raceCarRepository.save(raceCar);
    }
}
