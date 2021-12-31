package br.com.inthurn.VilaDevInHouse.utilities;

import java.text.DecimalFormat;

public class MoneyUtility {
    public static String convertToMoney(Object value){
        DecimalFormat decimalFormat = new DecimalFormat("'R$  '0.##");
        return decimalFormat.format(value);
    }
}
