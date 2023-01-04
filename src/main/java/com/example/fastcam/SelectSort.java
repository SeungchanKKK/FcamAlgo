package com.example.fastcam;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    public ArrayList<Integer>sort(ArrayList<Integer>dataList){
        int lowest;
        for(int i =0; i<dataList.size()-1;i++){
            lowest=i;
            for(int j =i+1; j<dataList.size(); j++){
                if(dataList.get(i)>dataList.get(j)){
                    lowest=j;
                }
            }
            Collections.swap(dataList,lowest,i);
        }
        return dataList;
    }
}
