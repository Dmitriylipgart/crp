package com.itechart.crp;

import com.itechart.crp.graph.Graph;
import com.itechart.crp.graph.Node;
import com.itechart.crp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableJpaRepositories
@SpringBootApplication
public class CrpApplication {

//    public static void main(String[] args) {
//
//        Graph graph = new Graph();
//        graph.init();
//
//        Node sourceCity = graph.getCities().get("San Francisco");
//
//        Set<Node> cities = graph.getReachableCities(sourceCity, 60);
//
//        System.out.println(cities);
//    }


public static void main(String[] args) {
    SpringApplication.run(CrpApplication.class, args);

}

}



