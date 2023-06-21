package com.example.fastcam;

public class MyLinkedList {
    public class Node<T> {
        T data;
        Node<T>next = null;

        public Node(T data){
            this.data= data;
        }
    }



    Node<Integer>node1 = new Node<>(1);
    Node<Integer>node2 = new Node<>(2);
}
