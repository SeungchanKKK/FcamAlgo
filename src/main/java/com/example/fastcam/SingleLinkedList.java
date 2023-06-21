package com.example.fastcam;

public class SingleLinkedList<T> {
    public Node<T>head = null;

    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if (head==null){
            head = new Node<>(data);
        }else {
            Node<T>node = this.head;
            while (node.next!=null){
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void printAll(){
        if(head==null){
            System.out.println("null");
        }else {
            Node<T>node = this.head;
            while (node.next!=null){
                System.out.println(node.data);
                node=node.next;
            }
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer>myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.printAll();
    }
}
