package com.example.fastcam;

import java.util.ArrayList;

public class SequencialSearch {
    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem){
        for (int i=0; i<dataList.size(); i++){
            if (dataList.get(i)==searchItem){
                return i;
            }
        }
        return -1;
    }
}
