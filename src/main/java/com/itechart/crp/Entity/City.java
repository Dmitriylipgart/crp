package com.itechart.crp.Entity;

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

    @Transient
    double distanceToSource = 0.0;

    @ElementCollection
    @CollectionTable(name="destinations")
    @MapKeyColumn(name="city_id")
    Map<City, Integer> adjCities = new HashMap<>();


    public City(String name) {
        this.name = name;
    }

}
