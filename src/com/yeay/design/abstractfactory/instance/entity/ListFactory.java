package com.yeay.design.abstractfactory.instance.entity;

import com.yeay.design.abstractfactory.instance.factory.Factory;
import com.yeay.design.abstractfactory.instance.factory.Link;
import com.yeay.design.abstractfactory.instance.factory.Page;
import com.yeay.design.abstractfactory.instance.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
