package com.cursoandroid.sergiodiniz.estudorecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursoandroid.sergiodiniz.estudorecyclerview.R;
import com.cursoandroid.sergiodiniz.estudorecyclerview.adapter.AdapterFilmes;
import com.cursoandroid.sergiodiniz.estudorecyclerview.model.Filme;
import com.cursoandroid.sergiodiniz.estudorecyclerview.utils.RecyclerItemClickListener;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getListaDeFilmes();

        recyclerView = findViewById(R.id.recyclerView);

        // configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes( this.filmes );

        // configurar gerenciador de RecyclerView (Manager)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        // configurar linha entre itens
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFilmes);

        // evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme  filme = filmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    String.format("%s - Shot Click", filme.getTitulo()),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = filmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    String.format("%s - Long Click", filme.getTitulo()),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public List<Filme> getListaDeFilmes(){
        // Lista de filmes
        this.filmes = Arrays.asList(
                criarFilme("Slender man", "Terror", "2018"),
                criarFilme("Megatubarão", "Fantasia", "2018"),
                criarFilme("O Protetor 2", "Ação", "2018"),
                criarFilme("Missão Impossivel - Efeito Fallout", "Ação", "2018"),
                criarFilme("Hotel Transilvânia 3: Férias Monstruosas", "Animação", "2018"),
                criarFilme("Christopher Robin - Um Reencontro Inesquecível", "Fantasia", "2018"),
                criarFilme("Os Incriveis 2", "Animação", "2018")
        );

        return filmes;
    }

    public Filme criarFilme(String titulo, String genero, String ano){
        return new Filme(titulo, genero, ano);
    }
}
