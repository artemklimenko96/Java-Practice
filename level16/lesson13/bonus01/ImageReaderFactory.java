package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Artem Klimenko on 23/06/2016.
 */
public class ImageReaderFactory

{
    public static ImageReader getReader(ImageTypes imageTypes)
    {
        if(imageTypes == imageTypes.JPG){
            return new JpgReader();
        }
        else if (imageTypes == imageTypes.PNG)
            return new PngReader();
        else if (imageTypes == imageTypes.BMP)
            return new BmpReader();
        else
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}

