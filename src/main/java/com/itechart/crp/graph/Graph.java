package com.itechart.crp.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class Graph {

    Map<String, Node> cities = new HashMap<>();

    Set<Node> visited = new HashSet<>();

    public Set<Node> getReachableCities(Node city, int time){
        city.setTimeToSource(0);
        Queue<Node> stack = Collections.asLifoQueue(new ArrayDeque<>());
        stack.add(city);
        while (!stack.isEmpty()) {
            Node node = stack.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Node n : node.getAdjNodes().keySet()) {
                    if(!visited.contains(n)){
                        int timeToSource = node.getTimeToSource() + node.getAdjNodes().get(n);
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

    private Map<Node, Integer> setNodes(Object[][] arr){
        return Stream.of(arr).collect(
                Collectors.toMap(data -> (Node) data[0], data -> (Integer) data[1]));
    }

    public void init() {

        Node SanFrancisco = new Node("San Francisco");
        Node DalyCity = new Node("Daly City");
        Node SanBruno = new Node("San Bruno");
        Node SanMateo = new Node("San Mateo");
        Node Redwood = new Node("Redwood");
        Node PaloAlto = new Node("Palo Alto");
        Node Hayward = new Node("Hayward");
        Node SanLeandro = new Node("San Leandro");
        Node Oakland = new Node("Oakland");
        Node Berkly = new Node("Berkly");
        Node Richmond = new Node("Richmond");
        Node SanRafael = new Node("San Rafael");
        Node MillValley = new Node("Mill Valley");


        cities.put(SanFrancisco.getName(), SanFrancisco);
        cities.put(DalyCity.getName(), DalyCity);
        cities.put(SanBruno.getName(), SanBruno);
        cities.put(SanMateo.getName(), SanMateo);
        cities.put(Redwood.getName(), Redwood);
        cities.put(Hayward.getName(), Hayward);
        cities.put(SanLeandro.getName(), SanLeandro);
        cities.put(Oakland.getName(), Oakland);
        cities.put(Berkly.getName(), Berkly);
        cities.put(Richmond.getName(), Richmond);
        cities.put(SanRafael.getName(), SanRafael);
        cities.put(MillValley.getName(), MillValley);
        cities.put(PaloAlto.getName(), PaloAlto);


        SanFrancisco.setAdjNodes(setNodes(new Object[][]{
                        {DalyCity, 10},
                        {SanBruno, 20},
                        {MillValley, 25},
                        {Oakland, 30}
                })
        );

        DalyCity.setAdjNodes(setNodes(new Object[][]{
                        {SanFrancisco, 10},
                        {SanBruno, 10}
                })
        );

        SanBruno.setAdjNodes(setNodes(new Object[][]{
                        {SanFrancisco, 20},
                        {DalyCity, 10},
                        {SanMateo, 20}
                })
        );

        SanMateo.setAdjNodes(setNodes(new Object[][]{
                        {SanBruno, 20},
                        {Redwood, 20},
                        {Hayward, 30}
                })
        );

        Redwood.setAdjNodes(setNodes(new Object[][]{
                        {SanMateo, 20},
                        {PaloAlto, 10}
                })
        );

        PaloAlto.setAdjNodes(setNodes(new Object[][]{
                        {Redwood, 10}

                })
        );

        Hayward.setAdjNodes(setNodes(new Object[][]{
                        {SanMateo, 30},
                        {SanLeandro, 20}
                })
        );

        SanLeandro.setAdjNodes(setNodes(new Object[][]{
                        {Hayward, 20},
                        {Oakland, 20}
                })
        );

        Oakland.setAdjNodes(setNodes(new Object[][]{
                        {SanLeandro, 20},
                        {Berkly, 10},
                        {SanFrancisco, 30},

                })
        );

        Berkly.setAdjNodes(setNodes(new Object[][]{
                        {Oakland, 10},
                        {Richmond, 20}
                })
        );

        Richmond.setAdjNodes(setNodes(new Object[][]{
                        {Berkly, 20},
                        {SanRafael, 20}
                })
        );

        SanRafael.setAdjNodes(setNodes(new Object[][]{
                        {Richmond, 20},
                        {MillValley, 20}
                })
        );

        MillValley.setAdjNodes(setNodes(new Object[][]{
                        {SanRafael, 20},
                        {SanFrancisco, 25}
                })
        );


    }



}
