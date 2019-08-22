package com.yeay.design.prototype.instance.entity;

import com.yeay.design.prototype.instance.framword.AbstractProduct;
import com.yeay.design.prototype.instance.framword.Product;

//public class MessageBox implements Product {
public class MessageBox extends AbstractProduct {
    private char decochar;

    public MessageBox(char decochar){
        this.decochar = decochar;
    }

    @Override
    public void use(String str) {
        int length = str.getBytes().length;

        for (int i = 0; i < length; i ++){
            System.out.println(decochar);
        }
        System.out.println(" ");

        System.out.println(decochar + " " + str + " " + decochar);

        for (int i = 0; i < length; i ++){
            System.out.println(decochar);
        }
        System.out.println(" ");
    }

//    @Override
//    public Product createClone() {
//        Product product = null;
//        try {
//            product = (Product) clone();
//
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
}
