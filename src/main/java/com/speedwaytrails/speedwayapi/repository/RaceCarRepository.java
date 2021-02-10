package com.speedwaytrails.speedwayapi.repository;

import com.speedwaytrails.speedwayapi.entity.RaceCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceCarRepository extends JpaRepository<RaceCar, Long> {
}
