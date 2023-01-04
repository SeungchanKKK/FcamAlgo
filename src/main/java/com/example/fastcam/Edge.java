package com.example.fastcam;

import org.aopalliance.intercept.Interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Edge implements Comparable<Edge>{

    public static void main(String args[]){
        PriorityQueue<Edge>priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(2,"A"));
        priorityQueue.add(new Edge(5,"B"));
        priorityQueue.offer(new Edge(1,"C"));
        priorityQueue.offer(new Edge(7,"D"));
        System.out.println(priorityQueue);

        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        DijkstraPath dijkstraPath = new DijkstraPath();
        dijkstraPath.dijkstraFunc(graph,"A");
    }
    public Integer distance;
    public String vertex;

    public Edge (Integer distance, String vertex){
        this.distance=distance;
        this.vertex = vertex;
    }

    //System.out.println()으로 객체 자체 출력시,
    public String toString(){
        return "vertex:"+this.vertex+",distance:"+this.distance;
    }

    @Override
    public int compareTo(Edge e){
        return this.distance - e.distance;
    }



}
