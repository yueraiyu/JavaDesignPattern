package com.yeay.design.adapter.instance.byEntrust;

public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(Banner banner){
        this.banner = banner;
    }

    @Override
    void printWeak() {
        banner.showWithParen();
    }

    @Override
    void printStrong() {
        banner.showWithAstar();
    }
}
