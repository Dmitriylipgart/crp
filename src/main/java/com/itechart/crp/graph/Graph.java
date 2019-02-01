package com.itechart.crp.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Graph {

    Set<Node> graph = new HashSet<>();
    Set<Node> visited = new HashSet<>();
    int count = 0;

    public boolean isCyclic(Collection<Node> nodes) {

        for (Node node : nodes) {
            count++;
            if (hasCycle(node)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        for (Node n : node.getAdjNodes()) {
            count++;
            if (hasCycle(n)) {
                return true;
            }
        }
        visited.remove(node);
        return false;
    }


    public void init() {

        Node node1 = new Node("Node #1");
        Node node2 = new Node("Node #2");
        Node node3 = new Node("Node #3");
        Node node4 = new Node("Node #4");
        Node node5 = new Node("Node #5");
        Node node6 = new Node("Node #6");

        node1.setAdjNodes(new HashSet<>(Arrays.asList(node2, node4)));
        node2.setAdjNodes(Collections.singleton(node3));
        node4.setAdjNodes(Collections.singleton(node5));
        node5.setAdjNodes(Collections.singleton(node6));
        node6.setAdjNodes(Collections.singleton(node4));

        graph.addAll(Arrays.asList(node1, node2, node3, node4, node5, node6));

    }


}
