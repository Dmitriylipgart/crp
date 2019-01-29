package com.itechart.crp.repository;

import com.itechart.crp.Entity.City;
import com.itechart.crp.graph.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findCityByNameStartingWith(String name);
}
