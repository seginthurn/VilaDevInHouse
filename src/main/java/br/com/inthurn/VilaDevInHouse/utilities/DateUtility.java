package br.com.inthurn.VilaDevInHouse.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtility {


    public static String dateFormatter(java.sql.Date sqlDate) {
        if(sqlDate == null){
            return null;
        }

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
        return simpleDateFormat.format(convertToJavaDate(sqlDate));

    }

    public static java.sql.Date dateFormatter(String date){
        date = date.replaceAll("[^0-9]", " ");
        String[] arr = date.split(" ");
        String newString = arr[2]+arr[1]+arr[0];
        return new java.sql.Date(Long.parseLong(newString));
    }

    public static Date convertToJavaDate(java.sql.Date date){
        return new Date(date.getTime());
    }

}
