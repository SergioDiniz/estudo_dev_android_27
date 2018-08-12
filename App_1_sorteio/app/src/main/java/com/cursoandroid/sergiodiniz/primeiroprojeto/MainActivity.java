package com.cursoandroid.sergiodiniz.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortearNumero(View view){

        int numero = new Random().nextInt(100) + 1;

        TextView mensagemNS = findViewById(R.id.mensagemNS);
        TextView valorNS = findViewById(R.id.valorNS);

        mensagemNS.setVisibility(View.VISIBLE);
        valorNS.setVisibility(View.VISIBLE);

        valorNS.setText(Integer.toString(numero));
    }
}
