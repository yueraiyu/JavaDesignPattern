package com.yeay.design.adapter.instance.byClass;

/**
 * 适配器
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String msg){
        super(msg);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAstar();
    }
}
