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
                api.calculateCurrency(c1,pln);
                output.setText(String.valueOf(api.calculateCurrency(c1,pln)));
            }
        });
    }

}