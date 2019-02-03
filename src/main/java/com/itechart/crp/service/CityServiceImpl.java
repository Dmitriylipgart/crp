package com.itechart.crp.service;

import com.itechart.crp.Entity.City;
import com.itechart.crp.repository.CityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    private final int AVERAGE_SPEED = 50;

    @Override
    @Transactional
    public Set<City> getReachableNodes(String cityName, int time){

        City city = getCityByName(cityName);
        Set<City> visited = new HashSet<>();
        city.setDistanceToSource(0);
        Queue<City> stack = Collections.asLifoQueue(new ArrayDeque<>());
        stack.add(city);

        while (!stack.isEmpty()) {
            City node = stack.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                for (City n : node.getAdjCities().keySet()) {
                    if(!visited.contains(n)){
                        double distanceToSource = node.getDistanceToSource() + node.getAdjCities().get(n);
                        double timeToSource = distanceToSource / AVERAGE_SPEED * 60;
                        if(timeToSource <= time){
                            if(n.getDistanceToSource() == 0 || distanceToSource < n.getDistanceToSource()){
                                n.setDistanceToSource(distanceToSource);
                            }
                            stack.add(n);
                        }
                    }
                }
            }
        }
        visited.remove(city);
        return visited;
    }


    @Override
    @Transactional
    public City getCityByName(String name){
        City city = cityRepository.findByName(name);
        return city;
    }

    @Override
    @Transactional
    public List<String> getCityNamesByName(String name){
        List<String> cities = cityRepository.findCitiesByNameContainingIgnoreCase(name, PageRequest.of(0, 10));
        return cities;
    }



    private Map<City, Integer> setCities(Object[][] arr){
        return Stream.of(arr).collect(
                Collectors.toMap(data -> (City) data[0], data -> (Integer) data[1]));
    }


}
