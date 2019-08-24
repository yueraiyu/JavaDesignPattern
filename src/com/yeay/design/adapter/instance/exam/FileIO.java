package com.yeay.design.adapter.instance.exam;

import java.io.IOException;

public interface FileIO {
    void readFromFile(String fileName) throws IOException;
    void writeToFile(String fileName) throws IOException;
    void setValue(String key, String value);
    String getValue(String key);
}
