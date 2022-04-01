package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("c1");
        String usd_str = intent.getStringExtra("usd_usd");
        double USD = Double.parseDouble(usd_str);
        String chf_str = intent.getStringExtra("chf_chf");
        double CHF = Double.parseDouble(usd_str);
        String eur_str = intent.getStringExtra("eur_eur");
        double EUR = Double.parseDouble(usd_str);

        EditText input = (EditText) findViewById(R.id.input_1);
        EditText output = (EditText) findViewById(R.id.input_2);

        TextView t2 = (TextView) findViewById(R.id.txt_c2);
        t2.setText(c1);
        API api = new API();

        Button bt_calculate = (Button) findViewById(R.id.bt_calc);
        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pln = Double.parseDouble(input.getText().toString());
                //output.setText("USD: " + usd_str.toString());
                switch (c1){
                    case "USD":
                        output.setText(String.valueOf(api.calculateCurrency("USD",pln,USD)));
                        break;
                    case "CHF":
                        output.setText(String.valueOf(api.calculateCurrency("CHF",pln,CHF)));
                        break;
                    case "EUR":
                        output.setText(String.valueOf(api.calculateCurrency("EUR",pln,EUR)));
                        break;

            }
                //output.setText(String.valueOf(api.calculateCurrency(c1,pln,USD)));
            }
        });
    }

}