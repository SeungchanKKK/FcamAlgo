package com.example.fastcam;

public class NodeMgmt {
    Node head= null;
    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value= value;
            this.left= null;
            this.right = null;
        }
    }

    public boolean insertNode(int data){
        if(this.head==null){
            this.head=new Node(data);
            return true;
        }else {
            Node node = this.head;
                while (true){
                    if (data<node.value){
                        if (node.left!=null){
                            node=node.left;
                        }else {
                            node.left= new Node(data);
                            return true;
                        }
                    }
                    else {
                        if (node.right!=null){
                            node=node.right;
                        }else {
                            node.right= new Node(data);
                            return true;
                        }
                    }
                }
        }
    }

    public Node search(int data){
        if (this.head==null){
            return null;
        }else {
            Node node = this.head;
            while (true){
                if (data<node.value){
                    if(node.left!=null){
                        node=node.left;
                    }else {
                        return null;
                    }
                } else if (data > node.value) {
                    if(node.right!=null){
                        node=node.right;
                    }else {
                        return null;
                    }
                }else {
                    return node;
                }
            }
        }
    }

    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);
    }
}
