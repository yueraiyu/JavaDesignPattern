package com.yeay.design.abstractfactory.instance.entity;

import com.yeay.design.abstractfactory.instance.factory.Item;
import com.yeay.design.abstractfactory.instance.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<ul>\n");
        Iterator<Item> iterator = content.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</address>\n");
        buffer.append("</body></html>\n");

        return buffer.toString();
    }
}
