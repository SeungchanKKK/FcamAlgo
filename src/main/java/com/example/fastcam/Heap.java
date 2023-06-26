package com.example.fastcam;


import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer>heapArray=null;

    public Heap (Integer data){
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data){
        Integer inserted_idx,parent_idx;
        if(heapArray==null){
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        inserted_idx=this.heapArray.size()-1;
        while (heapArray.get(inserted_idx)>heapArray.get(inserted_idx/2)&&inserted_idx>1){
            parent_idx=inserted_idx/2;
            Collections.swap(heapArray,inserted_idx,parent_idx);
            inserted_idx=parent_idx;
            if(inserted_idx==1){
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);
    }
}
