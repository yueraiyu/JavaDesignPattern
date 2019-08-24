package com.yeay.design.builder.instance;

import com.yeay.design.builder.instance.entity.HtmlBuilder;
import com.yeay.design.builder.instance.entity.TextBuilder;
import com.yeay.design.builder.instance.framwork.Director;

public class BuilderMain {
    public static void main(String[] args) {
        //text
        TextBuilder textBuilder = new TextBuilder();
        Director textdirector = new Director(textBuilder);
        textdirector.construct();
        System.out.println(textBuilder.getResult());

        //html
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        Director htmlDirector = new Director(htmlBuilder);
        htmlDirector.construct();
        System.out.println(htmlBuilder.getResult());
    }
}
