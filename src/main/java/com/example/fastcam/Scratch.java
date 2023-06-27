package com.example.fastcam;

import java.util.ArrayList;

public class Scratch {
    public int factorialFunc(int n) {
        if (n <= 1) {
            return 1;
        } else if (n==2) {
            return 2;
        }else if (n==3) {
            return 4;
        }
        else {
            return factorialFunc(n-1)+factorialFunc(n-2)+factorialFunc(n-3);
        }
    }


    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        System.out.println(scratch.factorialFunc(6));
    }
}
