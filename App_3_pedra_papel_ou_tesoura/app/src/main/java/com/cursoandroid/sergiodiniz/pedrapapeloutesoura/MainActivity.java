package com.cursoandroid.sergiodiniz.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer quantidadeJogadas;
    private Integer jogadorGanhou;
    private Integer computadorGanhou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        quantidadeJogadas = 0;
        jogadorGanhou = 0;
        computadorGanhou = 0;

        ((TextView) findViewById(R.id.vitoriaPlayer)).setText(this.jogadorGanhou.toString());
        ((TextView) findViewById(R.id.vitoriaComputador)).setText(this.computadorGanhou.toString());
    }

    public void escolherPedra(View view){
        compararEscolhas(Movimento.PEDRA);
    }

    public void escolherPapel(View view){
        compararEscolhas(Movimento.PAPEL);
    }

    public void escolherTesoura(View view){
        compararEscolhas(Movimento.TESOURA);
    }

    public Movimento escolhaComputador(){
        Movimento[] movimentos = Movimento.values();
        int index = new Random().nextInt(movimentos.length);
        setarImagemComputador(movimentos[index]);
        return movimentos[index];
    }

    public void compararEscolhas(Movimento movimento){
        String mensagem = "";
        int resultado = movimento.compareMovimento(escolhaComputador());
        if(resultado == 0){ // Empate
            alterarResultado(null);
            mensagem = "Empate";
        } else if(resultado == 1){ // vitoria
            alterarResultado(true);
            mensagem = "Você Ganhou";
        } else { // derrota
            alterarResultado(false);
            mensagem =  "Você Perdeu";
        }

        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();

    }

    public void setarImagemComputador(Movimento movimento){
        ImageView imageView = findViewById(R.id.imgBtComputador);
        if(movimento == Movimento.TESOURA){
            imageView.setImageResource(R.drawable.tesoura);
        } else if (movimento == Movimento.PAPEL){
            imageView.setImageResource(R.drawable.papel);
        } else {
            imageView.setImageResource(R.drawable.pedra);
        }
    }

    public void alterarResultado(Boolean jogadorGanhou){
        this.quantidadeJogadas += 1;
        if(jogadorGanhou == null) {}
        else if(jogadorGanhou) {
            this.jogadorGanhou += 1;
            ((TextView) findViewById(R.id.vitoriaPlayer)).setText(this.jogadorGanhou.toString());
        }
        else {
            this.computadorGanhou += 1;
            ((TextView) findViewById(R.id.vitoriaComputador)).setText(this.computadorGanhou.toString());
        }
    }

}
