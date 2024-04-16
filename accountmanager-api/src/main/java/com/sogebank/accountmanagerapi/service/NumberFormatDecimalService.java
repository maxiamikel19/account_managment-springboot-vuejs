package com.sogebank.accountmanagerapi.service;

import java.text.DecimalFormat;

public class NumberFormatDecimalService {
    public static double convertDoubleTwoDecimals(Double value) {
        DecimalFormat fmt = new DecimalFormat("0.00");      
        String string = fmt.format(value);
        String[] part = string.split("[,]");
        String string2 = part[0]+"."+part[1];
            double preco = Double.parseDouble(string2);
        return preco;
    }
}
