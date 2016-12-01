package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        boolean isSet = false;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if(entry.getValue()!=null){
                if(!isSet){
                    query.append(entry.getKey() + " = '" + entry.getValue() + "'");
                    isSet = true;
                }
                else {
                    query.append(" and " + entry.getKey() + " = '" + entry.getValue() + "'");
                }
            }

        }
        return query;
    }
}
