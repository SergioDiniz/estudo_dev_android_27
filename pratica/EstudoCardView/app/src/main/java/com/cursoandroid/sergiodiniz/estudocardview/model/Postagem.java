package com.cursoandroid.sergiodiniz.estudocardview.model;

public class Postagem {

    private String usuario;
    private String comentario;
    private int imagem;

    public Postagem() { }

    public Postagem(String usuario, String comentario, int imagem) {
        this.usuario = usuario;
        this.comentario = comentario;
        this.imagem = imagem;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
