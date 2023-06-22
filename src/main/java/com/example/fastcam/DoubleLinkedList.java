package com.example.fastcam;

public class DoubleLinkedList<T>{
    Node<T>head =null;
    Node<T>tail = null;
    public class Node<T>{
        T data;
        Node<T>prev = null;
        Node<T>next = null;

        public Node(T data){
            this.data= data;
        }
    }

    public void addNode(T data){
        if (this.head==null){
            this.head=new Node<>(data);
            this.tail = this.head;
        }else {
            Node<T>node = this.head;
            while (node.next!=null){
                node=node.next;
            }
            node.next=new Node<>(data);
            node.next.prev=node;
            this.tail=node.next;
        }
    }

    public void printAll(){
        if(head==null){
            System.out.println("null");
        }else {
            Node<T> node = this.head;
            while (node.next!=null){
                System.out.println(node.data);
                node=node.next;
            }
            System.out.println(node.data);
        }
    }

    public T searchFromHead(T isData){
        if(this.head==null){
            return null;
        }else {
            Node<T>node = this.head;
            while (node!=null){
                if (node.data==isData){
                    return node.data;
                }else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData){
        if (this.tail==null){
            return null;
        }else {
            Node<T>node = this.tail;
            while (node!=null){
                if (node.data==isData){
                    return node.data;
                }else {
                    node= node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData){
        if (this.head == null) {
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return true;
        }else if(head.data==existedData){
            Node<T>node = this.head;
            this.head = new Node<T>(addData);
            this.tail=node;
            head.next=node;
            node.prev= head;
            return true;
        }else {
            Node<T>node = this.head;
            while (node!=null){
                if (node.data==existedData){
                    Node<T>newNode = new Node<>(addData);
                    node.prev.next= newNode;
                    node.prev = newNode;
                    newNode.prev=node.prev;
                    newNode.next=node;
                    return true;
                }else {
                    node=node.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer>MyLinkedList = new DoubleLinkedList<>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }
}
