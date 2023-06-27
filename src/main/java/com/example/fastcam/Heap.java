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

    public boolean move_down(Integer popped_idx){
        Integer left_idx,right_idx;
        left_idx= popped_idx*2;
        right_idx = popped_idx*2+1;
        //자식노드없을때
        if (left_idx >= this.heapArray.size()){
            return false;
        }
        //왼쪽만있을때
        else if (right_idx >= this.heapArray.size()) {
            if (heapArray.get(popped_idx)<heapArray.get(left_idx)){
                return true;
            }else {
                return false;
            }
        }
        //둘다있을때
        else {
            Integer bigger;
            if (heapArray.get(left_idx)>heapArray.get(right_idx)){
                bigger=heapArray.get(left_idx);
            }else {
                bigger=heapArray.get(right_idx);
            }
            if (heapArray.get(popped_idx)<bigger){
                return true;
            }else {
                return false;
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_idx, right_idx;
        if (this.heapArray == null) {
            return null;
        } else {
            returned_data = heapArray.get(1);
            heapArray.set(1, heapArray.get(this.heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);
            popped_idx = 1;
            while (move_down(popped_idx)) {
                left_idx= popped_idx*2;
                right_idx = popped_idx*2+1;
                //왼쪽만있을때
                if (right_idx >= this.heapArray.size()) {
                    if (heapArray.get(popped_idx) < heapArray.get(left_idx)) {
                        Collections.swap(heapArray,popped_idx,left_idx);
                        popped_idx=left_idx;
                    }
                }
                //둘다있을때
                else {
                    Integer bigger;
                    if (heapArray.get(left_idx) > heapArray.get(right_idx)) {
                        bigger = left_idx;
                    } else {
                        bigger = right_idx;
                    }
                    if (heapArray.get(popped_idx) < heapArray.get(bigger)) {
                        Collections.swap(heapArray,popped_idx,bigger);
                        popped_idx=bigger;
                    }
                }
            }
            return returned_data;
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
