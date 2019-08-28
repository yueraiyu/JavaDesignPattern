package com.yeay.design.strategy.instance.entity;

import com.yeay.design.strategy.instance.strategy.Strategy;

public class Player {
    private String name;

    private Strategy strategy;

    private int winCount;

    private int loseCount;

    private int gameCount;

    public Player(String name, Strategy strategy){
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){
        return strategy.nextHand();
    }

    public void win(){
        strategy.study(true);
        winCount ++;
        gameCount ++;
    }

    public void lose(){
        strategy.study(false);
        loseCount ++;
        gameCount ++;
    }

    public void even(){
        gameCount ++;
    }

    @Override
    public String toString() {
        return "[" + name + ":" + gameCount + " games, " + winCount + " win, " + loseCount + " lose" +"]";
    }
}
