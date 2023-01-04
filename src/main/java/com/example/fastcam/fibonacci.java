package com.example.fastcam;

public class fibonacci {
    public int fibonacci(int data){
        if(data==0){
            return 0;
        }else if(data==1){
            return 1;
        }else {
            return this.fibonacci(data-2)+this.fibonacci(data-1);
        }
    }
}
