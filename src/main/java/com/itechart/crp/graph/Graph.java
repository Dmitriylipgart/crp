package com.itechart.crp.graph;

import java.util.*;

public class Graph {

    Set<Node> cities = new HashSet<>();

    Set<Node> visited = new HashSet<>();

    Set<Node> getReachableCities(Node city, int time){
        city.setTimeToSource(0);
        Queue<Node> stack = Collections.asLifoQueue(new ArrayDeque<>());
        stack.add(city);
        while (!stack.isEmpty()) {
            Node node = stack.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Node n : node.getAdjNodes().keySet()) {
                    n.setTimeToSource(node.getTimeToSource() + node.getAdjNodes().get(n));
                }
            }
        }
        return visited;
    }
}
