package com.example.fastcam;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge>{
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex){
        this.distance=distance;
        this.vertex=vertex;
    }

    public String toString(){
        return "vertex: "+this.vertex+", distance: "+ this.distance;
    }
    @Override
    public int compareTo(Edge e) {
        return this.distance-e.distance;
    }

    public static void main(String args[]) {
        Edge edge1 = new Edge(10,"A");
        Edge edge2 = new Edge(12,"A");
        Edge edge3 = new Edge(13,"A");
        Edge[] edges = new Edge[]{edge1,edge2,edge3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance-o1.distance;
            }
        });
        System.out.println(Arrays.toString(edges));
    }
}
