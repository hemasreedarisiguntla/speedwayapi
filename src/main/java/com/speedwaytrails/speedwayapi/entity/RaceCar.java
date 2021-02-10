package com.speedwaytrails.speedwayapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaceCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String model;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "racecar_driver",
            joinColumns = @JoinColumn(name = "racecar_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    private List<Driver> driverList;
    private String year;
    private String status;
    private Integer top_speed;
    private String type;



}
