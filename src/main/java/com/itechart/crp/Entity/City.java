package com.itechart.crp.Entity;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "city_name")
    String name;

    @Column(name = "state_name")
    String stateName;

    @Column(name = "state_id")
    int stateId;

    @Transient
    int distanceToSource;

    @ElementCollection
    @CollectionTable(name="destinations")
    @MapKeyColumn(name="city_id")
    Map<City, Integer> adjCities = new HashMap<>();


    public City(String name) {
        this.name = name;
    }

}
