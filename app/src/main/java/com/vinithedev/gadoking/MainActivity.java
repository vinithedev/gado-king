package com.vinithedev.gadoking;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView mytext;
    String local = "PR - Noroeste";
    int aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytext = (TextView)findViewById(R.id.mytext);

        Button mybutton = (Button) findViewById(R.id.mybutton);
        Button btnext = (Button) findViewById(R.id.btnext);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doit().execute();
            }
        });

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTwo();
            }
        });

    }

    public class doit extends AsyncTask<Void,Void,Void>{

        String words;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://canalrural.uol.com.br/cotacao/boi-gordo/").get();

                words = doc.text();

            } catch (IOException e) { e.printStackTrace(); }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            aux = words.indexOf(local);
            mytext.setText("Cotação atual(@ à vista): " + Character.toString(words.charAt(aux+14)) + Character.toString(words.charAt(aux+15)) + Character.toString(words.charAt(aux+16)) + Character.toString(words.charAt(aux+17)) + Character.toString(words.charAt(aux+18)) + Character.toString(words.charAt(aux+19)));
        }

    }

    public void openActivityTwo(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}









