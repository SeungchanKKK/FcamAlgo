package com.example.fastcam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DFS {
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> grpah, String startNode){
        Stack<String> needVisit = new Stack<>();
        ArrayList<String>visited = new ArrayList<>();
        needVisit.add(startNode);
        while (needVisit.size()>0){
            String node = needVisit.pop();
            if (!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(grpah.get(node));
            }
        }
        return visited;
    }
}
