package com.itechart.crp.service;

import com.itechart.crp.Entity.City;
import com.itechart.crp.graph.Node;
import com.itechart.crp.repository.CityRepository;
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

    public List<City> getReachableNodes(String cityName, int time){

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
                        int distanceToSource = node.getDistanceToSource() + node.getAdjCities().get(n);
                        int timeToSource = distanceToSource;
                        if(timeToSource <= time){
                            n.setTimeToSource(timeToSource);
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
        City city = cityRepository.findCityByNameStartingWith(name);
        return city;
    }

    @Override
    public void saveCity() {
        City SanFrancisco = new City("San Francisco");
        City DalyCity = new City("Daly City");
        City SanBruno = new City("San Bruno");

        cityRepository.saveAndFlush(SanFrancisco);
        cityRepository.saveAndFlush(DalyCity);
        cityRepository.saveAndFlush(SanBruno);

        SanFrancisco.setAdjCities(setCities(new Object[][]{
                        {DalyCity, 10},
                        {SanBruno, 20}
                })
        );

        DalyCity.setAdjCities(setCities(new Object[][]{
                        {SanFrancisco, 10},
                        {SanBruno, 10}
                })
        );

        SanBruno.setAdjCities(setCities(new Object[][]{
                        {SanFrancisco, 20},
                        {DalyCity, 10}
                })
        );

        cityRepository.saveAndFlush(SanFrancisco);
        cityRepository.saveAndFlush(DalyCity);
        cityRepository.saveAndFlush(SanBruno);
    }

    private Map<City, Integer> setCities(Object[][] arr){
        return Stream.of(arr).collect(
                Collectors.toMap(data -> (City) data[0], data -> (Integer) data[1]));
    }


}
