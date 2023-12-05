package com.solvd.laba.oopPractice;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class FileUtils {
    public void writeToFile(String filePath, String content) {
        try {
            // Using FileUtils.writeStringToFile to write content to the file
            org.apache.commons.io.FileUtils.writeStringToFile(new File(filePath), content, "UTF-8");
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> readFromFile(String filePath) {
        try {
            // Using FileUtils.readLines to read all lines from the file
            File file = new File(filePath);
            return org.apache.commons.io.FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
