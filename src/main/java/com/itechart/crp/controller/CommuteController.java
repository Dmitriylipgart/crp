package com.itechart.crp.controller;


import com.itechart.crp.Entity.City;
import com.itechart.crp.graph.Graph;
import com.itechart.crp.graph.Node;
import com.itechart.crp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/commute")
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
        Graph graph = new Graph();
        graph.init();
        Node sourceCity = graph.getCities().get(cityName);
        Set<Node> cities = graph.getReachableCities(sourceCity, minutes);
        return  cities.stream().map(Node::getName).collect(Collectors.toSet());
    }

    @PostMapping("/city")
    public void saveCity(){
        cityService.saveCity();
    }

    @GetMapping("/city")
    public City getCity(@RequestParam(name = "city") String cityName){
        return cityService.getCityByName(cityName);
    }
}
