package com.yeay.design.bridge.instance;

import com.yeay.design.bridge.instance.impl.DisplayImpl;

public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){
        open();
        for (int i = 0; i < times; i ++){
            print();
        }
        close();
    }
}
