package com.example.fastcam;

import java.util.ArrayList;

public class Split {
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

    public ArrayList<Integer>mergeFunc(ArrayList<Integer>leftList, ArrayList<Integer>rightList){
        ArrayList<Integer>mergedList = new ArrayList<Integer>();
        int leftPoint =0;
        int rightPoint =0;
        //Case 1 : 좌/우측 데이터 모두 존재할때
        while (leftList.size()>leftPoint&&rightList.size()>rightPoint){
            if(leftList.get(leftPoint)>rightList.get(rightPoint)){
                mergedList.add(rightList.get(rightPoint));
                rightPoint+=1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint+=1;
            }
        }
        //Case2 : 우측데이터만 없을때
        while (leftList.size()>leftPoint){
            mergedList.add(leftList.get(leftPoint));
            leftPoint+=1;
        }
        //Case2 : 좌측데이터만 없을때
        while (rightList.size()>rightPoint){
            mergedList.add(rightList.get(rightPoint));
            rightPoint+=1;
        }
        return mergedList;
    }
}
