package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> tokeny = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
          tokeny.add(token);
        }
        String[] ret = new String[tokeny.size()];
        for (int i = 0; i<ret.length; i++){
            ret[i] = tokeny.get(i);
        }
        return ret;
    }
}
