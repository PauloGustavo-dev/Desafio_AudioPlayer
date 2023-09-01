package br.com.alura.desafio_audioplayer.produtos;

import br.com.alura.desafio_audioplayer.turbo_player.playback;

public class Podcast extends Audio implements playback{
    
    private double velocidadeDeReproducao = 1;
    
    public Podcast(String nome) {
        super(nome);
    }

    public double getVelocidadeDeReproducao() {
        return velocidadeDeReproducao;
    }

    public void aumentarVelocidadeDeReproducao(){
        if (velocidadeDeReproducao == 0.75){
            velocidadeDeReproducao = 1;
        } else if (velocidadeDeReproducao == 3){
            System.out.println("Reproduzindo na velocidade maxima");
        } else {
            velocidadeDeReproducao += 1;
            System.out.println("Reproduzindo na velcidade: X" + this.getVelocidadeDeReproducao());
        }
    }
    public void abaixarVelocidadeDeReproducao(){
        if (velocidadeDeReproducao == 1){
            velocidadeDeReproducao = 0.75;
        } else if (velocidadeDeReproducao == 0.75){
            System.out.println("Reproduzindo na velocidade mínima");
        } else {
            velocidadeDeReproducao -= 1;
            System.out.println("Reproduzindo na velcidade: X" + this.getVelocidadeDeReproducao());
        }
    }
}
