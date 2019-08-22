package com.yeay.design.prototype.instance.entity;

import com.yeay.design.prototype.instance.framword.AbstractProduct;
import com.yeay.design.prototype.instance.framword.Product;

//public class UnderLinePen implements Product {
public class UnderLinePen extends AbstractProduct {
    private char ulchar;

    public UnderLinePen(char ulchar){
        this.ulchar = ulchar;
    }

    @Override
    public void use(String str) {
        int length = str.getBytes().length;

        System.out.println("\"" + str + "\"");
        System.out.println(" ");

        for (int i = 0; i < length; i ++){
            System.out.println(ulchar);
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
