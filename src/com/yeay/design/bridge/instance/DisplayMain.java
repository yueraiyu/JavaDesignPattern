package com.yeay.design.bridge.instance;

import com.yeay.design.bridge.instance.impl.StringDisplayImpl;

public class DisplayMain {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello"));
        Display d2 = new Display(new StringDisplayImpl("Hi"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Bye"));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("En..."));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);

        d4.display();
        d4.randomDisplay(5);
    }
}
