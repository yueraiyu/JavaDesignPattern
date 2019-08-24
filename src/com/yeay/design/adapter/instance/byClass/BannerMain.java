package com.yeay.design.adapter.instance.byClass;

public class BannerMain {
    public static void main(String[] args) {
        Print print = new PrintBanner("hello");

        print.printWeak();
        print.printStrong();
    }
}
