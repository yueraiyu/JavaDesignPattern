package com.yeay.design.builder.instance.framwork;

//public abstract class Builder {
//    public abstract void makeTitle(String title);
//
//    public abstract void makeString(String str);
//
//    public abstract void makeItem(String[] items);
//
//    public abstract void close();
//}

public interface Builder {
    void makeTitle(String title);

    void makeString(String str);

    void makeItem(String[] items);

    void close();
}