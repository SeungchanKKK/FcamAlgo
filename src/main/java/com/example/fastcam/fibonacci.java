package com.example.fastcam;

public class fibonacci {
    public int fibonacci(int data){
        int []arr = new int[data+1];
        arr[0]=0;
        arr[1]=1;
        for (int i=2; i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[data];
    }

    public static void main(String[] args) {
        fibonacci fibonacci= new fibonacci();
        System.out.println(fibonacci.fibonacci(9));
    }
}
