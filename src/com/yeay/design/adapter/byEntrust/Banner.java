package com.yeay.design.adapter.byEntrust;

/**
 * 实际情况
 */
public class Banner {
    private String msg;

    public Banner(String msg){
        this.msg = msg;
    }

    public void showWithParen(){
        System.out.println("(" + this.msg + ")");
    }

    public void showWithAstar(){
        System.out.println("*" + this.msg + "*");
    }
}
