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

                Intent intent = new Intent(getApplicationContext(), Calculator.class);
                intent.putExtra("c1",currency_1);
                startActivity(intent);
            }
        });
    }


}