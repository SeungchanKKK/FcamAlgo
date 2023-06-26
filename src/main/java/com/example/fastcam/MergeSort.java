package com.example.fastcam;

import java.util.ArrayList;

public class MergeSort {
    public void spliter(ArrayList<Integer>data){
        if(data.size()<=1){
            return;
        }
        int medium = data.size()/2;
        ArrayList<Integer> leftArray = new ArrayList<>(data.subList(0,medium));
        ArrayList<Integer> rightArray = new ArrayList<>(data.subList(medium,data.size()));

        System.out.println(leftArray);
        System.out.println(rightArray);
    }
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;
        //좌,우 양쪽다있을때
        while (leftPoint<leftList.size()&&rightPoint<rightList.size()){
            if (leftList.get(leftPoint)>rightList.get(rightPoint)){
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            }else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }
        //왼쪽만 없을떄
        while (rightPoint<rightList.size()){
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }
        //오른쪽만 없을때
        while (leftPoint<leftList.size()){
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }
        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
        if(dataList.size()<=1){
            return dataList;
        }
        int medium = dataList.size()/2;
        ArrayList<Integer> leftArray = mergeSplitFunc(new ArrayList<>(dataList.subList(0,medium)));
        ArrayList<Integer> rightArray = mergeSplitFunc(new ArrayList<>(dataList.subList(medium,dataList.size())));

        return mergeFunc(leftArray,rightArray);
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.mergeSplitFunc(testData));
    }
}
