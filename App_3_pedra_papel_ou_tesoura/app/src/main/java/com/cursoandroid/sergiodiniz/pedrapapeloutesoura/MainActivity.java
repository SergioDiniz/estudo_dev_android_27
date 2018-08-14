package com.cursoandroid.sergiodiniz.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer quantidadeJogadas = 0;
    private Integer jogadorGanhou = 0;
    private Integer computadorGanhou = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolherPedra(View view){
        compararEscolhas(Movimento.PAPEL);
    }

    public void escolherPapel(View view){
        compararEscolhas(Movimento.PAPEL);
    }

    public void escolherTesoura(View view){
        compararEscolhas(Movimento.TESOURA);
    }

    public Movimento escolhaComputador(){
        Movimento[] movimentos = Movimento.values();
        int index = new Random().nextInt(movimentos.length - 1);
        return movimentos[index];
    }

    public void compararEscolhas(Movimento movimento){

        int resultado = movimento.compareMovimento(escolhaComputador());
        if(resultado == 0){
            alterarResultado(null);
        } else if(resultado == 1){
            alterarResultado(true);
        } else {
            alterarResultado(false);
        }

    }

    public void alterarResultado(Boolean jogadorGanhou){
        this.quantidadeJogadas += 1;
        if(jogadorGanhou == null) {}
        else if(jogadorGanhou) this.jogadorGanhou += 1;
        else this.computadorGanhou += 1;
    }

}
