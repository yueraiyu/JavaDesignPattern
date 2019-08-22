package com.yeay.design.factorymethod.instance.framword;

/**
 * 工厂类，定义生产流程，具体生成交由子类实现
 */
public abstract class Factory {
    public Product create(String owner){
        Product product = createProduce(owner);
        registerProduce(product);
        return product;
    }

    public abstract void registerProduce(Product product);

    public abstract Product createProduce(String owner);
}
