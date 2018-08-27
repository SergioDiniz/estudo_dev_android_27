package com.cursoandroid.sergiodiniz.estudorecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cursoandroid.sergiodiniz.estudorecyclerview.R;
import com.cursoandroid.sergiodiniz.estudorecyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.FilmesViewHolder>{

    private List<Filme> filmes;

    public AdapterFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // cria a visualização, passando a layout para a inner class

        View lista = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.lista_filme_ad, viewGroup, false);

        return new FilmesViewHolder(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmesViewHolder filmesViewHolder, int i) {
        // configura a exibição com os item definidos na inner class

        Filme filme = filmes.get(i);

        filmesViewHolder.titulo.setText(filme.getTitulo());
        filmesViewHolder.genero.setText(filme.getGenero());
        filmesViewHolder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }



    public class FilmesViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public FilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }

}
