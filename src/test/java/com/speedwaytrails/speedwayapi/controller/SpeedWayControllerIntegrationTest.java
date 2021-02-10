package com.speedwaytrails.speedwayapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpeedWayControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

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
}
