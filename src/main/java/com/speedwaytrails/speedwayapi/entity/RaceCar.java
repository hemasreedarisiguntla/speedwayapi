package com.speedwaytrails.speedwayapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RaceCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String model;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "racecar_driver",
            joinColumns = @JoinColumn(name = "racecar_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    private final Set<Driver> driverList =new HashSet<>();
    private String year;
    private String status;
    private Integer top_speed;
    private String type;



}
