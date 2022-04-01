package com.example;


import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class API{

        double USD_Currency = 0.0;
        double CHF_Currency = 0.0;
        double EUR_Currency = 0.0;
        private static final DecimalFormat df = new DecimalFormat("0.00");

//        public API(){
//            getCurrency("chf");
//            getCurrency("usd");
//            getCurrency("eur");
//            System.out.println("Eur:" + getEUR_Currency());
//            System.out.println("Usd:" + getUSD_Currency());
//            System.out.println("Chf:" + getCHF_Currency());
//        }

//    public void getCurrency(String code){
//        String myUrl = "http://api.nbp.pl/api/exchangerates/rates/a/usd";
//        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
//                response -> {
//                    try{
//                        //Create a JSON object containing information from the API.
//                        JSONObject myJsonObject = new JSONObject(response);
//                        JSONArray array = (JSONArray) myJsonObject.get("rates");
//                        JSONObject rate = (JSONObject) array.get(0);
//                        Double rateMid = (Double) rate.get("mid");
//                        System.out.println("rateMid: " + rateMid);
//                        // totalRecoveredWorld.setText(myJsonObject.getString("recovered"));
//                        // totalDeathsWorld.setText(myJsonObject.getString("deaths"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                volleyError -> System.out.println(volleyError.getMessage())
//        );
//        RequestQueue requestQueue = new RequestQueue();
//    }




        public double calculateCurrency(String code, double pln, double currency){
            double result = 66.00;

            result = pln / currency;

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

    public void setCHF_Currency(double CHF_Currency) {
        this.CHF_Currency = CHF_Currency;
    }

    public void setEUR_Currency(double EUR_Currency) {
        this.EUR_Currency = EUR_Currency;
    }

    public void setUSD_Currency(double USD_Currency) {
        this.USD_Currency = USD_Currency;
    }


}
