package com.yeay.design.builder.instance.entity;

import com.yeay.design.builder.instance.framwork.Builder;

//public class TextBuilder extends Builder {
public class TextBuilder implements Builder {
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("==============================");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("+" + str + "\n");
    }

    @Override
    public void makeItem(String[] items) {
        for (String item:items) {
            buffer.append("    ." + item + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("==============================");
    }

    public String getResult(){
        return this.buffer.toString();
    }
}
