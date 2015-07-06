package com.example.kevin.sunshine_second_activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Kevin on 11/06/2015.
 */
public class SecondActivity extends Activity {
    private TextView textView;
    private TextView textView2;
    private TextView textView3;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        String dia = getIntent().getStringExtra("dia");
        String temperatura = getIntent().getStringExtra("temperatura");
        String estado = getIntent().getStringExtra("estado");

        textView.setText(dia);
        textView2.setText(temperatura);
        textView3.setText(estado);
    }
}
