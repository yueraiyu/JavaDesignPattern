package com.yeay.design.strategy.instance;

import com.yeay.design.strategy.instance.entity.Hand;
import com.yeay.design.strategy.instance.entity.Player;
import com.yeay.design.strategy.instance.strategy.ProbStrategy;
import com.yeay.design.strategy.instance.strategy.WinningStrategy;

import java.util.Random;

public class StrategyMain {
    public static void main(String[] args) {
        Player player1 = new Player("Taro", new WinningStrategy(new Random(10).nextInt(10)));
        Player player2 = new Player("Hana", new ProbStrategy(new Random(5).nextInt(5)));

        for(int i = 0; i < 1000; i++){
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();


            if (hand1.isStrongerThan(hand2)){
                System.out.println("Winner : " + player1);
                player1.win();
                player2.lose();
            }if (hand1.isWeakerThan(hand2)){
                System.out.println("Winner : " + player2);
                player2.win();
                player1.lose();
            }else{
                System.out.println("Even ....");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total result : ");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
