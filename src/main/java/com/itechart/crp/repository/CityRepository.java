package com.itechart.crp.repository;

import com.itechart.crp.Entity.City;
import com.itechart.crp.graph.Node;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
    List<City> findAllByNameContainingIgnoreCase(String cityName);

    @Query("select c.name from City c where lower(c.name) like lower(concat(?1, '%'))")
    List<String> findCitiesByNameContainingIgnoreCase(String cityName, Pageable pageable);

    City findByName(String cityName);
}
