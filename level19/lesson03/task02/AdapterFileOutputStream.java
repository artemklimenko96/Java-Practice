package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream stream1;
    AdapterFileOutputStream(FileOutputStream stream1){
        this.stream1 = stream1;
    }

    @Override
    public void writeString(String s) throws IOException
    {

       stream1.write(s.getBytes());
    }

    @Override
    public void flush() throws IOException
    {
        stream1.flush();
    }

    @Override
    public void close() throws IOException
    {
        stream1.close();
    }
}

