package com.example.fastcam;

import java.util.ArrayList;

public class MyQue<T> {
    ArrayList<T> QueList = new ArrayList<>();

    public void add(T a) {
        QueList.add(a);
    }

    public boolean offer(T a) {
        QueList.add(a);
        return true;
    }

    public T poll() {
        if (QueList.isEmpty()) {
            return null;
        }
        T a = QueList.get(0);
        QueList.remove(0);
        return a;
    }

    public T remove() {
        if (QueList.isEmpty()) {
            return null;
        }
        T a = QueList.get(0);
        QueList.remove(0);
        return a;
    }

    public boolean isEmpty(){
        if (QueList.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyQue<Integer>que = new MyQue<>();
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println(que.isEmpty());
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.isEmpty());
    }
}
