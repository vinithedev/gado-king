package com.vinithedev.gadoking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    static String receita;
    static String roi;
    TextView roiValor;
    TextView receitaValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        receitaValor = (TextView)findViewById(R.id.receitaValor);
        roiValor = (TextView)findViewById(R.id.roiValor);

        receitaValor.setText(receita);
        roiValor.setText(roi);

    }

}
