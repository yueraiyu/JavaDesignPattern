package com.yeay.design.builder.instance;

public abstract class Home {
    public Home(){
        System.out.println("Home init");
        buildPart1();
        buildPart2();
        buildPart3();
        buildPart4();
    }

    protected abstract void buildPart1();
    protected abstract void buildPart2();
    protected abstract void buildPart3();
    protected abstract void buildPart4();
}
