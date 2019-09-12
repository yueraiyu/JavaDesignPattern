package com.yeay.design.templatemethod.instance;

public abstract class AbstractDisplay {
    public final void display(){ //禁止子类覆盖该方法
        open();
        for (int i = 0; i < 5; i ++){
            print();
        }
        close();
    }

    public AbstractDisplay(){}

    public abstract void open();
    public abstract void print();
    public abstract void close();
}
