package com.itechart.crp.service;

import com.itechart.crp.Entity.City;

import java.util.Set;

public interface CityService {

    City getCityByName(String cityName);
    Set<City> getReachableNodes(String cityName, int time);
}
