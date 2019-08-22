package com.yeay.design.factorymethod.instance.entity;

import com.yeay.design.factorymethod.instance.entity.IDCard;
import com.yeay.design.factorymethod.instance.framword.Factory;
import com.yeay.design.factorymethod.instance.framword.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List<Product> cards = new ArrayList<>();

    @Override
    public void registerProduce(Product product) {
        cards.add(product);
    }

    @Override
    public Product createProduce(String owner) {
        return new IDCard(owner);
    }
}
