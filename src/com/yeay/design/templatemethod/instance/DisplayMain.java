package com.yeay.design.templatemethod.instance;

public class DisplayMain {
    public static void main(String[] args) {
//        AbstractDisplay d1 = new CharDisplay('c');
//        AbstractDisplay d2 = new StringDisplay("s");

        Display d1 = new CharDisplay('c');
        Display d2 = new StringDisplay("s");

        d1.display();
        d2.display();
    }
}
