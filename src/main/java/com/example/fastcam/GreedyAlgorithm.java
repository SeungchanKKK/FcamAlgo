package com.example.fastcam;

import java.util.ArrayList;

public class GreedyAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer> coinList){
        Integer totalCoinCount =0;
        Integer coinNum =0;
        ArrayList<Integer> details = new ArrayList<>();

        for(int i =0; i<coinList.size();i++){
            coinNum = price/coinList.get(i);
            totalCoinCount +=coinNum;
            price-= coinNum*coinList.get(i);
            details.add(coinNum);
            System.out.println(coinList.get(i)+"원"+coinNum+"개");
        }
        System.out.println("총 동전개수"+totalCoinCount);
    }
}
