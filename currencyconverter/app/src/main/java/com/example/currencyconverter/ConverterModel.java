package com.example.currencyconverter;

import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.BufferedInputStream;


public class ConverterModel extends MainActivity {

    static double  Calculate(String currency2) {
        double money = 1.0;

        if (currency2 == "PESO") {
            money = money * 19.15;
            return money;
        }

        if (currency2 == "POUND") {
            money = money * .7664;
            return money;
        }

        if (currency2 == "CAD") {
            money = money * 1.13;
            return money;
        }

        if (currency2 == "EUR") {
            money = money * .8828;
            return money;
        }

        else
             return money;
    }

    static double ConversionRate(String text, double item) {
        double amount = Double.parseDouble(text);
        amount = item * amount;
        return amount;
    }

}
