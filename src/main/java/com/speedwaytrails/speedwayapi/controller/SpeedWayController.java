package com.speedwaytrails.speedwayapi.controller;

import com.speedwaytrails.speedwayapi.entity.RaceCar;
import com.speedwaytrails.speedwayapi.service.SpeedWayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"speedwaytrails"})
public class SpeedWayController {

    @Autowired
    SpeedWayService speedWayService;

    @GetMapping("/api/v1/racecars")
    public List<RaceCar> getAllRaceCars() {
        return speedWayService.getAllRaceCars();
    }
}
