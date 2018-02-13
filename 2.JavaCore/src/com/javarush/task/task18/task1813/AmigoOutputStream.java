package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    FileOutputStream component;

    public AmigoOutputStream (FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }

    public void write(int b) throws IOException {
        component.write(b);
    }

    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    public void flush() throws IOException {
        component.flush();
    }

    public void close() throws IOException {
        component.flush();
        component.write("JavaRush © All rights reserved.".getBytes());
        component.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
