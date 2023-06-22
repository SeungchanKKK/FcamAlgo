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
    public Node<T>search(T data){
        if (this.head==null){
            return null;
        }else {
            Node<T> node = this.head;
            while(node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }
    public void addNodeInside(T data, T isData){
        Node<T>isNode = this.search(isData);
        if (isNode==null){
            this.addNode(data);
        } else {
            Node<T>node  = new Node<>(data);
            node.next= isNode.next;
            isNode.next=node;
        }
    }

    public boolean delNode(T isData){
        if (this.head==null){
            return false;
        }else {
            Node<T>node= this.head;
            if (node.data==isData){
                this.head=node.next;
                return true;
            }else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer>myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        myLinkedList.delNode(3);
        myLinkedList.delNode(20);
        myLinkedList.printAll();
    }
}
