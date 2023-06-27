package com.example.fastcam;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer>sort(ArrayList<Integer>dataList){
        for (int i=0; i< dataList.size()-1; i++){
            Integer smallest =i;
            for (int j=i+1; j<dataList.size(); j++){
                if (dataList.get(j)<dataList.get(smallest)){
                    smallest= j;
                }
            }
            Collections.swap(dataList,smallest,i);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        SelectionSort sSort = new SelectionSort();
        System.out.println(sSort.sort(testData));
    }
}
