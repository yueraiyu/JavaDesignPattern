package com.yeay.design.prototype.instance.framword;

public interface Product extends Cloneable{
    void use(String str);

    Product createClone();
}
