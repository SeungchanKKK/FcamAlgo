package com.example.fastcam;

import java.util.ArrayList;
import java.util.Arrays;

public class Split {
    public void spliter(ArrayList<Integer> data){
        if(data.size()<=1){
            return;
        }
        int medium = data.size()/2;
        ArrayList<Integer>left = new ArrayList<>( data.subList(0,medium));
        ArrayList<Integer>right = new ArrayList<>( data.subList(medium,data.size()));
        System.out.println(left);
        System.out.println(right);
    }

    public static void main(String[] args) {
        Split sObject = new Split();
        sObject.spliter(new ArrayList<Integer>(Arrays.asList(4, 1, 2, 3, 5, 7)));
    }
}
