package com.example.fastcam;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer>sort(ArrayList<Integer>dataList){
        for(int i=0; i<dataList.size()-1;i++){
            boolean swap = false;
            for (int j =0; j<dataList.size()-1-i;j++){
                if(dataList.get(j)>dataList.get(j+1)){
                    Collections.swap(dataList,j,j+1);
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
        }
        return dataList;
    }
}
