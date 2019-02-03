package com.itechart.crp.controller;


import com.itechart.crp.Entity.City;
import com.itechart.crp.graph.Graph;
import com.itechart.crp.graph.Node;
import com.itechart.crp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/commute")
@CrossOrigin
public class CommuteController {


    private final CityService cityService;

    @Autowired
    public CommuteController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/range")
    public Set<String> getReachableCities(@RequestParam(value = "city") String cityName,
                                           @RequestParam(value = "minutes") int minutes)
    {
        Set<City> cities = cityService.getReachableNodes(cityName, minutes);
        return  cities.stream().map(City::getName).collect(Collectors.toSet());
    }


    @GetMapping("/city")
    public List<City> getCities(@RequestParam(name = "city") String cityName){
        return cityService.getCitiesByName(cityName);
    }
    @GetMapping("/cities")
    public List<String> getCityNames(@RequestParam(name = "city") String cityName){
        return cityService.getCityNamesByName(cityName);
    }
}
