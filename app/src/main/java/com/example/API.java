package com.example;


import java.text.DecimalFormat;

public class API {

        double USD_Currency = 4.26;
        double CHF_Currency = 4.59;
        double EUR_Currency = 4.68;
        private static final DecimalFormat df = new DecimalFormat("0.00");

        public void getCurrency(String code){
            String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + code;


        }

        public double calculateCurrency(String code, double pln){
            double result = 0.00;

            switch (code){
                case "USD":
                    result = pln * USD_Currency;
                    break;
                case "CHF":
                    result = pln * CHF_Currency;
                    break;
                case "EUR":
                    result = pln * EUR_Currency;
                    break;

            }
            result = Double.parseDouble(df.format(result));
            System.out.println("Result: " + result);

            return result;
        }

    public double getCHF_Currency() {
        return CHF_Currency;
    }

    public double getEUR_Currency() {
        return EUR_Currency;
    }

    public double getUSD_Currency() {
        return USD_Currency;
    }
}
