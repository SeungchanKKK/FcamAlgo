package com.example.fastcam;

import java.util.ArrayList;
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
                int minDistance = ways.get(i).distance+baseDistance;
                if (distances.get(ways.get(i).vertex)<minDistance){
                    distances.put(ways.get(i).vertex,minDistance);
                    priorityQueue.add(ways.get(i));
                }
            }
        }
    }
}
