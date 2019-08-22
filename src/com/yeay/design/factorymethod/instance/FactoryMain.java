package com.yeay.design.factorymethod.instance;

import com.yeay.design.factorymethod.instance.entity.IDCardFactory;
import com.yeay.design.factorymethod.instance.framword.Factory;
import com.yeay.design.factorymethod.instance.framword.Product;

public class FactoryMain {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product product1 = factory.create("张三");
        Product product2 = factory.create("李四");
        Product product3 = factory.create("王五");

        product1.use();
        product2.use();
        product3.use();
    }
}
