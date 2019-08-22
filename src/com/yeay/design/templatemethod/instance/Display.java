package com.yeay.design.templatemethod.instance;

public interface Display {
    int i = 0;

    default void display(){
        System.out.println(i);
        open();
        for (int i = 0; i < 5; i ++){
            print();
        }
        close();
    }

    void open();
    void print();
    void close();
}
