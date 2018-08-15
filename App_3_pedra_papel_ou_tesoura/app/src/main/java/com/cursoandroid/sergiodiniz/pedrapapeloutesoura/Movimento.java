package com.cursoandroid.sergiodiniz.pedrapapeloutesoura;

public enum Movimento {
    PEDRA,
    PAPEL,
    TESOURA;

    public int compareMovimento(Movimento outroMovimento){
        // empate
        if(this == outroMovimento) return 0;

        switch (this){
            case PEDRA: return (outroMovimento == TESOURA ? 1 : -1);
            case PAPEL: return (outroMovimento == PEDRA ? 1 : -1);
            case TESOURA: return (outroMovimento == PAPEL ? 1 : -1);
        }

        return 0;
    }
}
