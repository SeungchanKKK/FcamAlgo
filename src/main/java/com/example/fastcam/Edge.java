package com.example.fastcam;

public class Edge implements Comparable<Edge>{
    public int weight;
    public String node1;
    public String node2;

    public Edge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }
}
