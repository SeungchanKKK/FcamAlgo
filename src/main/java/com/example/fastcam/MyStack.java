package com.example.fastcam;

import java.util.ArrayList;

public class MyStack<T> {
    ArrayList<T>stackList = new ArrayList<>();

    public T push(T a){
        stackList.add(a);
        return a;
    }

    public T pop(){
        T value=stackList.get(stackList.size()-1);
        stackList.remove(value);
        return value;
    }

    public boolean isEmpty(){
        if (stackList.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer>myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
