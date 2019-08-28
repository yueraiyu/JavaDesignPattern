package com.yeay.design.strategy.instance.entity;

public class Hand {

    private static final int HAND_GUU = 0; //石头
    private static final int HAND_CHO = 1; //剪刀
    private static final int HAND_PAA = 2; //布

    private static final Hand[] hands = {
        new Hand(HAND_GUU),
        new Hand(HAND_CHO),
        new Hand(HAND_PAA)
    };

    private static final String[] names = {"石头", "剪刀", "布"};

    private int value;

    private Hand(int value){
        this.value = value;
    }

    public static Hand getHand(int value){
        return hands[value];
    }

    public boolean isStrongerThan(Hand hand){
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand){
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand){
            return 0;
        }else if ((this.value + 1) % 3 == hand.value){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString(){
        return names[value];
    }
}
