package com.example.fastcam;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    int[] dataList = {4,1,2,5,7};
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        if (dataList.size()<=1){
            return dataList;
        }
        int pivot = dataList.get(0);
        ArrayList<Integer>leftArr = new ArrayList<>();
        ArrayList<Integer>rightArr = new ArrayList<>();
        for (int i=1; i<dataList.size();i++){
            if (dataList.get(i)<pivot){
                leftArr.add(dataList.get(i));
            }else {
                rightArr.add(dataList.get(i));
            }
        }
        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(sort(rightArr));

        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        QuickSort qSort = new QuickSort();
        System.out.println(qSort.sort(testData));
    }
}
