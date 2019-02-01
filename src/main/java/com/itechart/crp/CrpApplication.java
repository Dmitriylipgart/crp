package com.itechart.crp;

import com.itechart.crp.graph.Graph;
import com.itechart.crp.graph.Node;

import java.util.Set;


public class CrpApplication {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.init();
        System.out.println(graph.isCyclic(graph.getGraph()));
        System.out.println(graph.getCount());
    }

}



