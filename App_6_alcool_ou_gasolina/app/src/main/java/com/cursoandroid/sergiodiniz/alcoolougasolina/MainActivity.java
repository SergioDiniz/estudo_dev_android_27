package com.cursoandroid.sergiodiniz.alcoolougasolina;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private EditText etAlcool;
    private EditText etGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvResultado = findViewById(R.id.twResultado);
        tvResultado.setVisibility(View.GONE);


    }

    public void calcular(View view){

        etAlcool = findViewById(R.id.etAlcool);
        etGasolina = findViewById(R.id.etGasolina);

        String messagem = "Informe os valor corretamente";

        if(validarValores()){
            Double resultado = Double.parseDouble(etAlcool.getText().toString()) / Double.parseDouble(etGasolina.getText().toString());
            if(resultado >= 0.7){
                messagem = "A melhor opção é Gasolina";
                tvResultado.setTextColor(Color.RED);
            }else{
                messagem = "A melhor opção é Álcool";
                tvResultado.setTextColor(Color.GREEN);
            }
        } else tvResultado.setTextColor(Color.BLACK);

        tvResultado.setText(messagem);
        tvResultado.setVisibility(View.VISIBLE);


    }

    public Boolean validarValores(){
        Boolean resultado = true;

        String sValorAlcool = etAlcool.getText().toString();
        if(sValorAlcool == null || sValorAlcool.isEmpty()) resultado = false;

        String sValorGasolina = etGasolina.getText().toString();
        if(sValorGasolina == null || sValorGasolina.isEmpty()) resultado = false;

        return resultado;
    }
}
