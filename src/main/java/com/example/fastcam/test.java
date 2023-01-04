package com.example.fastcam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class test {
    public static void main(String[] args){
        DoubleLinkedList<Integer>list= new DoubleLinkedList<Integer>();
        list.addNode(2);
        list.addNode(4);
        list.addNode(5);
        list.addNode(8);
        list.addNode(3);

        list.printAll();
    }
}
