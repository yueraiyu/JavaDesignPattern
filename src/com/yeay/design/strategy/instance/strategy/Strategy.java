package com.yeay.design.strategy.instance.strategy;

import com.yeay.design.strategy.instance.entity.Hand;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
