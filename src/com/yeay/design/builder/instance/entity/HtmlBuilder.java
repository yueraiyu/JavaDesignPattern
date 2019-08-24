package com.yeay.design.builder.instance.entity;

import com.yeay.design.builder.instance.framwork.Builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//public class HtmlBuilder extends Builder {
public class HtmlBuilder implements Builder {
    private String filename;

    private PrintWriter writer;


    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(new File(filename));
            writer.println("<html><body><head><title>" + title + "</title></head>");
            writer.println("<h1>" + title + "</h1>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
//            writer.close();
        }

    }

    @Override
    public void makeString(String str) {
        writer.println("<p>" + str + "</p>");
    }

    @Override
    public void makeItem(String[] items) {
        writer.println("<ul>");
        for (String item:items) {
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult(){
        return filename;
    }
}
