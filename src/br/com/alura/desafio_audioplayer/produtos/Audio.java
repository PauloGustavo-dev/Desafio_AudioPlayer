package br.com.alura.desafio_audioplayer.produtos;

public class Audio {
    private String nome;
    private double duracaoEmMinutos;
    private int totalDeReproducoes ;
    private int curtidas = 0;
    // classificacao

    public Audio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(double duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }
    public int getCurtidas() {
        return curtidas;
    }
    public void play(){
        System.out.println("Tocando " + this.getNome());
        this.totalDeReproducoes += 1;
    }
    public void curtir(){
        this.curtidas += 1;
    }
}
