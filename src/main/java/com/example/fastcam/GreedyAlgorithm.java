package com.example.fastcam;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    public void knapsackFunc(Integer[][] objectList, double capacity){
        double totalValue = 0.0;
        double fraction = 0.0;
        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] objectItem2) {
                return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
            }
        });

        for (int i=0; i<objectList.length; i++){
            if (capacity>objectList[i][0]){
                capacity-=objectList[i][0];
                totalValue+=objectList[i][1];
            }else {
                totalValue+=capacity/objectList[i][0]*objectList[i][1];
                break;
            }
        }
        System.out.println(totalValue);
    }

    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
