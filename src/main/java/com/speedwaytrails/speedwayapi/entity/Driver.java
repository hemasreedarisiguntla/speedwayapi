package com.speedwaytrails.speedwayapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String nickname;
    @ManyToMany(mappedBy = "driverList")
    private List<RaceCar> cars;
    private Integer wins;
    private Integer losses;
}
