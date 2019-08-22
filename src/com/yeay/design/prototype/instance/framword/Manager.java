package com.yeay.design.prototype.instance.framword;

import java.util.HashMap;

public class Manager {
//    private HashMap<String, Product> showCase = new HashMap<>();

//    public void register(String name, Product product){
//        showCase.put(name, product);
//    }
private HashMap<String, AbstractProduct> showCase = new HashMap<>();

    public void register(String name, AbstractProduct product){
        showCase.put(name, product);
    }

    public AbstractProduct create(String name){
        return showCase.get(name).createClone();
    }
}
