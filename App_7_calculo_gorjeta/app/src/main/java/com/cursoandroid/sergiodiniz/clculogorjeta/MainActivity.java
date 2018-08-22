package com.cursoandroid.sergiodiniz.clculogorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private TextView tvGorjeta;
    private TextView tvTotal;
    private TextView tvProcentagem;
    private SeekBar seekBarProcentagem;
    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        porcentagem = 0.00;

        etValor = findViewById(R.id.etValor);
        tvGorjeta = findViewById(R.id.tvGorjeta);
        tvTotal = findViewById(R.id.tvTotal);
        tvProcentagem = findViewById(R.id.tvPorcentagem);
        seekBarProcentagem = findViewById(R.id.seekBarProcentagem);

        this.seekbarAction();

    }

    public void seekbarAction(){
        seekBarProcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                tvProcentagem.setText(porcentagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        double valor = Double.parseDouble( etValor.getText().toString() );
        double gorjeta = Math.round(valor * (porcentagem/100));
        double total = valor + gorjeta;

        tvGorjeta.setText("R$ " + gorjeta);
        tvTotal.setText("R$ " + total);

    }

}
