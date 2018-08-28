package com.cursoandroid.sergiodiniz.estudocardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroid.sergiodiniz.estudocardview.R;
import com.cursoandroid.sergiodiniz.estudocardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.PostemViewHolder> {

    private List<Postagem> postagens = new ArrayList<>();

    public PostagemAdapter(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @NonNull
    @Override
    public PostemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View layout = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.postagem_detalhes, viewGroup, false);

        return new PostemViewHolder(layout);

    }

    @Override
    public void onBindViewHolder(@NonNull PostemViewHolder holder, int i) {
        Postagem p = postagens.get(i);
        holder.textUsuario.setText(p.getUsuario());
        holder.textComentario.setText(p.getComentario());
        holder.imagePostagem.setImageResource(p.getImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class PostemViewHolder extends RecyclerView.ViewHolder{

        private TextView textUsuario;
        private TextView textComentario;
        private ImageView imagePostagem;

        public PostemViewHolder(@NonNull View itemView) {
            super(itemView);

            textUsuario = itemView.findViewById(R.id.textUsuario);
            textComentario = itemView.findViewById(R.id.textComentario);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);

        }
    }

}
