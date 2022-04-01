package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> currencyList = new ArrayList<>();
    String currency_1;
    String currency_2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyList.add("EUR");
        currencyList.add("USD");
        currencyList.add("CHF");
        Intent intent = new Intent(getApplicationContext(), Calculator.class);
        API api = new API();
        String myUrl = "http://api.nbp.pl/api/exchangerates/rates/a/usd";
        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        JSONArray array = (JSONArray) myJsonObject.get("rates");
                        JSONObject rate = (JSONObject) array.get(0);
                        Double rateMid = (Double) rate.get("mid");
                        System.out.println("RATEMID: " + rateMid);
                        intent.putExtra("usd_usd" , rateMid.toString());


                        // totalRecoveredWorld.setText(myJsonObject.getString("recovered"));
                        // totalDeathsWorld.setText(myJsonObject.getString("deaths"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(),
                        Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(myRequest);


        String myUrl2 = "http://api.nbp.pl/api/exchangerates/rates/a/chf";
        StringRequest myRequest2 = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        JSONArray array = (JSONArray) myJsonObject.get("rates");
                        JSONObject rate = (JSONObject) array.get(0);
                        Double rateMid = (Double) rate.get("mid");
                        System.out.println("RATEMID: " + rateMid);
                        intent.putExtra("chf_chf" , rateMid.toString());


                        // totalRecoveredWorld.setText(myJsonObject.getString("recovered"));
                        // totalDeathsWorld.setText(myJsonObject.getString("deaths"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(),
                        Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue2 = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(myRequest2);


        String myUrl3 = "http://api.nbp.pl/api/exchangerates/rates/a/eur";
        StringRequest myRequest3 = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        JSONArray array = (JSONArray) myJsonObject.get("rates");
                        JSONObject rate = (JSONObject) array.get(0);
                        Double rateMid = (Double) rate.get("mid");
                        System.out.println("RATEMID: " + rateMid);
                        intent.putExtra("eur_eur" , rateMid.toString());


                        // totalRecoveredWorld.setText(myJsonObject.getString("recovered"));
                        // totalDeathsWorld.setText(myJsonObject.getString("deaths"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(),
                        Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue3 = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(myRequest3);

        Spinner s1 = (Spinner) findViewById(R.id.spinner_1);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, currencyList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);



        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newCurrency = s1.getSelectedItem().toString();
                //System.out.println("Item: " + s1.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button bt_calculate = (Button) findViewById(R.id.bt_1_calculate);
        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currency_1 = s1.getSelectedItem().toString();
                intent.putExtra("c1",currency_1);

                startActivity(intent);
            }
        });
    }






}