package com.yeay.design.prototype.instance;

import com.yeay.design.prototype.instance.entity.MessageBox;
import com.yeay.design.prototype.instance.entity.UnderLinePen;
import com.yeay.design.prototype.instance.framword.AbstractProduct;
import com.yeay.design.prototype.instance.framword.Manager;
import com.yeay.design.prototype.instance.framword.Product;

public class PrototypeMain {
    public static void main(String[] args) {
        Manager manager = new Manager();

        UnderLinePen underLinePen = new UnderLinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        manager.register("strong message", underLinePen);
        manager.register("waring box", mbox);
        manager.register("slash box", sbox);

//        Product p1 = manager.create("strong message");
//        p1.use("p1");
//
//        Product p2 = manager.create("waring box");
//        p2.use("p2");
//
//        Product p3 = manager.create("slash box");
//        p3.use("p3");

        AbstractProduct p1 = manager.create("strong message");
        p1.use("p1");

        AbstractProduct p2 = manager.create("waring box");
        p2.use("p2");

        AbstractProduct p3 = manager.create("slash box");
        p3.use("p3");
    }
}
