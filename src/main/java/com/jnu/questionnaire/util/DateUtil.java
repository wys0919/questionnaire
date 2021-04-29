package com.jnu.questionnaire.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToString(Date date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");  //日期格式
        String string = myFormat.format(date);
        return string;
    }

    public static Date stringToDate(String string) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");  //日期格式
        Date date = null;
        try {
            date = myFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
