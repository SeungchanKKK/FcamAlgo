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

    public boolean delete(int value){
        boolean searched = false;
        if (this.head==null){
            return false;
        }
        Node parentNode = this.head;
        Node node = this.head;
        // 코너 케이스2: Node 가 단지 하나만 있고, 해당 Node 가 삭제할 Node 일 때
        if (head.value==value && this.head.left == null && this.head.right == null){
            this.head=null;
            return true;
        }
        while (node!=null){
            if (value==node.value){
                searched=true;
                break;
            } else if (value<node.value) {
                parentNode=node;
                node=node.left;
            }else {
                parentNode=node;
                node=node.right;
            }
        }
        if (searched){
            // Case1: 삭제할 Node 가 Leaf Node 인 경우
            if(node.left==null&&node.right==null){
                if(node.value<parentNode.value){
                    parentNode.left=null;
                    node = null;
                }else {
                    parentNode.right=null;
                    node=null;
                }
            }
            // Case2-1: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (왼쪽에 Child Node 가 있을 경우)
            else if (node.left != null && node.right == null) {
                if (value < parentNode.value) {
                    parentNode.left = node.left;
                    node = null;
                } else {
                    parentNode.right = node.left;
                    node = null;
                }
            }
            // Case2-2: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 Child Node 가 있을 경우)
            else if (node.right != null && node.left == null){
                if (value < parentNode.value) {
                    parentNode.left = node.right;
                    node = null;
                } else {
                    parentNode.right = node.right;
                    node = null;
                }
            }
            // Case3-1: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)
            else {
                // 삭제할 Node 가 부모 Node 의 왼쪽에 있을 때
                if (value < parentNode.value) {
                    Node changeParentNode = node;
                    Node changeNode = node.right;
                    while (changeNode.left!=null){
                        changeParentNode=changeNode;
                        changeNode=changeNode.left;
                    }
                    // Case 3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    if (changeNode.right!=null){
                        changeParentNode.left =changeNode.right;
                        // Case 3-1-1: changeNode 의 Child Node 가 없을 때
                    }else {
                        changeParentNode.left = null;
                    }
                    changeNode.right=node.right;
                    changeNode.left = node.left;
                    parentNode.left= changeNode;

                    node = null;
                }else {
                    // Case3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 오른쪽에 있을 때)
                    Node changeParentNode = node;
                    Node changeNode = node.right;
                    while (changeNode.left!=null){
                        changeParentNode=changeNode;
                        changeNode=changeNode.left;
                    }
                    // Case 3-2-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    if (changeNode.right!=null){
                        changeParentNode.left =changeNode.right;
                        // Case 3-2-1: changeNode 의 Child Node 가 없을 때
                    }else {
                        changeParentNode.left = null;
                    }
                    changeNode.right=node.right;
                    changeNode.left = node.left;
                    parentNode.right= changeNode;

                    node = null;
                }
            }
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
       System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}
