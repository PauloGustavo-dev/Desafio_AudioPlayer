package br.com.alura.desafio_audioplayer.lista_audios;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.desafio_audioplayer.produtos.Ebook;
import br.com.alura.desafio_audioplayer.produtos.Musica;
import br.com.alura.desafio_audioplayer.produtos.Podcast;

public class Listas {
    public static List<Musica> listaMusicas(){
        Musica musica1 = new Musica("Like a Stone");
        Musica musica2 = new Musica("Stairwat to Heaven");
        Musica musica3 = new Musica("Come as you are");

        musica1.setDuracaoEmMinutos(4.54);

        List<Musica> listaMusicas = new ArrayList<>();
        listaMusicas.add(musica1);
        listaMusicas.add(musica2);
        listaMusicas.add(musica3);
        return listaMusicas;
    }
    public static List<Podcast> listaPodcasts(){
        Podcast podcast1 = new Podcast("Flow Podcast");
        Podcast podcast2 = new Podcast("Venus Podcast");
        Podcast podcast3 = new Podcast("Ciência Sem Fim");

        List<Podcast> listaPodcasts = new ArrayList<>();
        listaPodcasts.add(podcast1);
        listaPodcasts.add(podcast2);
        listaPodcasts.add(podcast3);
        return listaPodcasts;
    }
    public static List<Ebook> listaEbooks(){
        Ebook ebook1 = new Ebook("O Hobit");
        Ebook ebook2 = new Ebook("Senhor dos aneis: As duas torres");
        Ebook ebook3 = new Ebook("Harry Potter e a Pedra Filosofal");

        List<Ebook> listaEbooks = new ArrayList<>();
        listaEbooks.add(ebook1);
        listaEbooks.add(ebook2);
        listaEbooks.add(ebook3);

        return listaEbooks;
    }
}
