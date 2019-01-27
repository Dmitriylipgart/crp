package com.itechart.crp.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Node {
    String name;
    Map<Node, Integer> adjNodes = new HashMap<>();
    Integer timeToSource;
}
