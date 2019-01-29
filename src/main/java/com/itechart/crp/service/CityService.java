package com.itechart.crp.service;

import com.itechart.crp.Entity.City;

public interface CityService {
    void saveCity();
    City getCityByName(String cityName);
}
