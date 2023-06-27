package com.example.fastcam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){

        HashMap<String, Integer> distances = new HashMap<>();
        for (String node: graph.keySet()){
            distances.put(node,Integer.MAX_VALUE);
        }
        distances.put(start,0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(0,start));
        while (priorityQueue.size()>0){
            Edge node =priorityQueue.poll();
            int baseDistance = node.distance;
            if (distances.get(node.vertex) < baseDistance) {
                continue;
            }
            ArrayList<Edge>ways= graph.get(node.vertex);
            for (int i=0; i<ways.size();i++){
                int minDistance = ways.get(i).distance;
                String way =ways.get(i).vertex;
                if (distances.get(way)>minDistance+baseDistance){
                    distances.put(way,minDistance+baseDistance);
                    priorityQueue.add(new Edge(minDistance+baseDistance,way));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
        DijkstraPath dObject = new DijkstraPath();
        System.out.println(dObject.dijkstraFunc(graph, "A"));
    }
}
