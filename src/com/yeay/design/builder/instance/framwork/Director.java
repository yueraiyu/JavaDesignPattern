package com.yeay.design.builder.instance.framwork;

public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("From morning to afternoon");
        builder.makeItem(new String[]{"Good morning", "Good afternoon"});
        builder.makeString("evening");
        builder.makeItem(new String[]{"Good evening", "Good night", "Goodbye"});
        builder.close();
    }
}
