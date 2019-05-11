package com.vinithedev.gadoking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView roiValor, receitaValor;
    EditText qntbezedit, tampropedit, idadebezedit;
    Main3Activity m3 = new Main3Activity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button voltar = (Button) findViewById(R.id.buttonVoltar);
        Button proximo = (Button) findViewById(R.id.buttonNext);

        qntbezedit = (EditText) findViewById(R.id.qntbezedit);
        tampropedit = (EditText) findViewById(R.id.tampropedit);
        idadebezedit = (EditText) findViewById(R.id.idadebezedit);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityOne();
            }
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityThree();

                Double qntbezerro = Double.parseDouble(qntbezedit.getText().toString());
                Double cotacao = 149.50;
                Double receita = qntbezerro * cotacao * 20;
                Double mes = Double.parseDouble(idadebezedit.getText().toString());
                Double custoMedio = 30 * (36-mes) * qntbezerro;
                Double tamanhoProp = Double.parseDouble(tampropedit.getText().toString());
                Double arrendamentoAno = (tamanhoProp/10000) * 1600.0;
                Double custoTotal = custoMedio + arrendamentoAno;

                m3.receita = "R$" + receita.toString();

                Double dbroi = (receita - custoTotal) / arrendamentoAno;
                m3.roi = "R$" + dbroi.toString();

            }
        });

    }

    public void openActivityOne(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivityThree(){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

}
