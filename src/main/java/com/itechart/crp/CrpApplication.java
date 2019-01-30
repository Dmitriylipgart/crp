package com.itechart.crp;

import com.itechart.crp.graph.Graph;
import com.itechart.crp.graph.Node;

import java.util.Set;


public class CrpApplication {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.init();

        Node sourceCity = graph.getCities().get("San Francisco");

        Set<Node> cities = graph.getReachableCities(sourceCity, 30);

        System.out.println(cities);
    }

}



