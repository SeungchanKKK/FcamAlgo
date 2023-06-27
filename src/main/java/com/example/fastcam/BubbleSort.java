package com.example.fastcam;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer>sort(ArrayList<Integer> dataList){
        for (int i=0; i<dataList.size()-1;i++){
            boolean changed =false;
            for (int j=0; j<dataList.size()-1-i;j++){
                if (dataList.get(j)>dataList.get(j+1)){
                    Collections.swap(dataList,j,j+1);
                    changed=true;
                }
            }
            if (!changed){
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        BubbleSort bSort = new BubbleSort();
        System.out.println(bSort.sort(testData));
    }
}
