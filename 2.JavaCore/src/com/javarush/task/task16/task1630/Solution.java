package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName,
                        fileContent = "";
        public void setFileName (String fullFileName) {
            this.fullFileName = fullFileName;
        }
        public String getFileContent() {
            return fileContent;

        }
        public void run() {
            try {
                //option 1
                //List<String> result = Files.readAllLines(Paths.get(fullFileName), StandardCharsets.UTF_8);

                //option 2
                BufferedReader fileReader = new BufferedReader (new FileReader(fullFileName));
                String line;
                while ((line = fileReader.readLine())!=null) {
                    fileContent+=line+" ";
                }
                fileReader.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

}
