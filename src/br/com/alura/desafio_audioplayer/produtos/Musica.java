package br.com.alura.desafio_audioplayer.produtos;

public class Musica extends Audio{

    public Musica(String nome) {
        super(nome);
    }

    @Override
    public String toString(){
        return this.getNome();
    }
    
}
