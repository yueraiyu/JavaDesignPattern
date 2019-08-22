package com.yeay.design.templatemethod.instance;

//public class StringDisplay extends AbstractDisplay {
public class StringDisplay implements Display {
    private String str;

    public StringDisplay(String str){
        this.str = str;
    }

    @Override
    public void open() {
        System.out.print("{");
    }

    @Override
    public void print() {
        System.out.print(str);
    }

    @Override
    public void close() {
        System.out.print("}");
    }
}
