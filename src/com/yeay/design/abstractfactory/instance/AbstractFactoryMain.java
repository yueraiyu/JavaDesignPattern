package com.yeay.design.abstractfactory.instance;

import com.yeay.design.abstractfactory.instance.factory.Factory;
import com.yeay.design.abstractfactory.instance.factory.Link;
import com.yeay.design.abstractfactory.instance.factory.Page;
import com.yeay.design.abstractfactory.instance.factory.Tray;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory("com.yeay.design.abstractfactory.instance.entity.ListFactory");

        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com");
        Link jp_yahoo = factory.createLink("Yahoo!Jpan", "http://www.yahoo.co.jp");

        Link excite = factory.createLink("Excite", "http://www.excite.com");
        Link google = factory.createLink("Google", "http://www.google.com");

        Tray traynews = factory.createTray("日报");
        traynews.add(us_yahoo);
        traynews.add(jp_yahoo);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("搜索引擎");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "****");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
