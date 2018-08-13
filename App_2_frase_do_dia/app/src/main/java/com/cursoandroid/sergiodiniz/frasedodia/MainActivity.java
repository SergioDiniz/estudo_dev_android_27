package com.cursoandroid.sergiodiniz.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selecionarFrase();
    }

    public void mudarFrase(View view){
        selecionarFrase();
    }

    public void selecionarFrase(){
        TextView frase = findViewById(R.id.frase);
        frase.setText(getFrase());
    }

    public String getFrase(){
        List<String> frases = Arrays.asList(
                "Que o vento leve o necessário e me traga o suficiente.",
                "Algumas vezes coisas ruins acontecem em nossas vidas para nos colocar na direção das melhores coisas que poderíamos viver.",
                "Nunca saberemos o quão forte somos até que ser forte seja a única escolha.",
                "Se a caminhada está difícil, é porque você está no caminho certo.",
                "Seja você mesmo, todos os outros já existem.",
                "Inspira. Respira. Não pira.",
                "Eu ainda não cheguei lá, mas estou mais perto do que ontem.",
                "Se eu não mudar o que faço hoje, todos os amanhãs serão iguais a ontem.");

        int index = new Random().nextInt(frases.size() - 1);

        return frases.get(index);
    }
}
