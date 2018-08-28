package com.cursoandroid.sergiodiniz.estudocardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.cursoandroid.sergiodiniz.estudocardview.R;
import com.cursoandroid.sergiodiniz.estudocardview.adapter.PostagemAdapter;
import com.cursoandroid.sergiodiniz.estudocardview.model.Postagem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        // configuração do adapter
        PostagemAdapter adapter = new PostagemAdapter(gerarPostagens());

        // Gerenciador de RV
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);

        // Configurando RV
        recyclerPostagem.setLayoutManager(layoutManager);
        recyclerPostagem.setHasFixedSize(true);

        recyclerPostagem.setAdapter(adapter);


    }


    public List<Postagem> gerarPostagens(){

        return Arrays.asList(
                new Postagem("Bayard Jr", " #100daysofcode ultrices nulla netus molestie eros sit molestie", R.drawable.imagem2),
                new Postagem("Simão It.", "Sociosqu congue curabitur placerat volutpat mauris class commodo donec, facilisis malesuada phasellus nostra pulvinar vitae velit quam, dapibus dictum felis suscipit lobortis maecenas tristique. erat ut sodales dolor etiam mauris non egestas, ac tellus congue tortor vel nulla torquent cras. Sociosqu congue curabitur placerat volutpat mauris class commodo donec, facilisis malesuada phasellus nostra pulvinar vitae velit quam, dapibus dictum felis suscipit lobortis maecenas tristique. erat ut sodales dolor etiam mauris non egestas, ac tellus congue tortor vel nulla torquent cras. Sociosqu congue curabitur placerat volutpat mauris class commodo donec, facilisis malesuada phasellus nostra pulvinar vitae velit quam, dapibus dictum felis suscipit lobortis maecenas tristique. erat ut sodales dolor etiam mauris non egestas, ac tellus congue tortor vel nulla torquent cras.", R.drawable.imagem3),
                new Postagem("Sérgio Diniz", "Faucibus porttitor dictumst cras", R.drawable.imagem4),
                new Postagem("Sérgio Diniz", "Lorem ipsum placerat netus venenatis praesent ut eget lacus, vitae rhoncus mattis quisque aliquam", R.drawable.imagem1)
        );

    }



}
