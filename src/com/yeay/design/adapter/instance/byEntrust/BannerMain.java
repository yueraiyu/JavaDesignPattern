package com.yeay.design.adapter.instance.byEntrust;


public class BannerMain {
    public static void main(String[] args) {
        Print print = new PrintBanner(new Banner("hello"));

        print.printWeak();
        print.printStrong();
    }
}
