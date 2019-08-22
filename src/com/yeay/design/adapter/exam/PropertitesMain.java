package com.yeay.design.adapter.exam;

import java.io.IOException;

public class PropertitesMain {
    public static void main(String[] args) {
        FileIO io = new FilePropertites();

        try {
            io.readFromFile("/Users/yeah/dev/idea/JavaDesignPattern/src/com/yeay/design/adapter/instance/file.txt");
            System.out.println(io.getValue("year"));
            io.setValue("year", "2004");
            io.setValue("month", "4");
            io.setValue("day", "21");
            io.writeToFile("/Users/yeah/dev/idea/JavaDesignPattern/src/com/yeay/design/adapter/instance/newfile.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
