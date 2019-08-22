package com.yeay.design.factorymethod.instance.entity;

import com.yeay.design.factorymethod.instance.framword.Product;

public class IDCard extends Product {
    private String name;

    public IDCard(String name){
        System.out.println("create " + name + "'s id card");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void use() {
        System.out.println(name + "use id card");
    }
}
