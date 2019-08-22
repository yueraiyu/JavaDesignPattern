package com.yeay.design.prototype.instance.framword;

public abstract class AbstractProduct implements Cloneable {
    public abstract void use(String str);

    public AbstractProduct createClone() {
        AbstractProduct product = null;
        try {
            product = (AbstractProduct) clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return product;
    }
}
