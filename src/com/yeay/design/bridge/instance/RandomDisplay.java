package com.yeay.design.bridge.instance;

import com.yeay.design.bridge.instance.impl.DisplayImpl;

import java.util.Random;

public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times){
        open();
        for (int i = 0; i < new Random().nextInt(times); i ++){
            print();
        }
        close();
    }
}
