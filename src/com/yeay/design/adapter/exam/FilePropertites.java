package com.yeay.design.adapter.exam;

import sun.util.resources.LocaleData;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FilePropertites implements FileIO {
    private Map<String, String> propertites;

    public FilePropertites(){
        this.propertites = new HashMap<>(10);
    }

    @Override
    public void readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()){
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try{
                String record = "";
                while ((record = ((BufferedReader) reader).readLine()) != null){
                    String[] records = record.split("=");
                    if (records != null && records.length == 2){
                        propertites.put(records[0], records[1]);
                    }
                }
            }finally {
                reader.close();
            }
        }

    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }

        Writer writer = new FileWriter(file);

        try{
            StringBuffer sb = new StringBuffer("");
            sb.append("#written by FilePropertites\n");
            sb.append("#" + Calendar.getInstance().toString() + "\n");
            for (Map.Entry<String, String> entry : propertites.entrySet()){
                sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.write(sb.toString());
        }finally {
            writer.close();
        }
    }

    @Override
    public void setValue(String key, String value) {
        propertites.put(key, value);
    }

    @Override
    public String getValue(String key) {
        return propertites.get(key);
    }
}
