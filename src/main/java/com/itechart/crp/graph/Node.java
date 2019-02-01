package com.itechart.crp.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Node {
    String name;
    Set<Node> adjNodes = new HashSet<>();


    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
