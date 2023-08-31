package br.com.alura.desafio_audioplayer.principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.desafio_audioplayer.produtos.Ebook;
import br.com.alura.desafio_audioplayer.produtos.Musica;
import br.com.alura.desafio_audioplayer.produtos.Podcast;

public class AppMenus {

    static boolean menuPrincipal() {

        Scanner leitor = new Scanner(System.in);
        String escolhaMenuApresentacao = "0";

        String menu_apresentacao = """

                Bem Vindo ao Audio Player
                Escolha o conteudo que deseja reproduzir:
                1 - Musicas
                2 - Podcast
                3 - Ebook
                4 - Playlist Personalizada
                5 - Sair
                digite o numero da opção escolhida:""";
        ;

        while (escolhaMenuApresentacao.equals("0")) {

            System.out.println(menu_apresentacao);
            escolhaMenuApresentacao = leitor.nextLine();

            switch (escolhaMenuApresentacao) {
                case "1":
                    menuPlay("musica");
                    break;
                case "2":
                    menuPlay("podcast");
                    break;
                case "3":
                    menuPlay("ebook");
                    break;
                case "4":
                    System.out.println("Playlist");
                    break;
                case "5":
                    leitor.close();
                    return false;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    escolhaMenuApresentacao = "0";
                    break;
            }

        }
        return true;
    }

    static void menuPlay(String opcao) {
        Musica musica1 = new Musica("Like a Stone", 4.54);
        Musica musica2 = new Musica("Stairwat to Heaven", 8.02);
        Musica musica3 = new Musica("Come as you are", 3.38);

        List<Musica> listaMusicas = new ArrayList<>();
        listaMusicas.add(musica1);
        listaMusicas.add(musica2);
        listaMusicas.add(musica3);

        Podcast podcast1 = new Podcast("Flow Podcast");
        Podcast podcast2 = new Podcast("Venus Podcast");
        Podcast podcast3 = new Podcast("Ciência Sem Fim");

        List<Podcast> listaPodcasts = new ArrayList<>();
        listaPodcasts.add(podcast1);
        listaPodcasts.add(podcast2);
        listaPodcasts.add(podcast3);

        Ebook ebook1 = new Ebook("O Hobit");
        Ebook ebook2 = new Ebook("Senhor dos aneis 1");
        Ebook ebook3 = new Ebook("Harry Potter 1");

        List<Ebook> listaEbooks = new ArrayList<>();
        listaEbooks.add(ebook1);
        listaEbooks.add(ebook2);
        listaEbooks.add(ebook3);

        Scanner leitor = new Scanner(System.in);
        String escolhaMenuPlay = "0";

        String menu_play = """

                1 - play
                2 - duracao
                3 - cantor/banda
                4 - curtir
                5 - voltar para menu principal
                digite o numero da opção escolhida:""";

        System.out.println(opcao + "s disponiveis : ");
        int i = 1;
        switch (opcao) {
            case "musica":
                for (Musica m : listaMusicas) {
                    System.out.println(i + " - " + m.getNome());
                    i += 1;
                }
                break;
            case "podcast":
                for (Podcast m : listaPodcasts) {
                    System.out.println(i + " - " + m.getNome());
                    i += 1;
                }
                break;
            case "ebook":
                for (Ebook m : listaEbooks) {
                    System.out.println(i + " - " + m.getNome());
                    i += 1;
                }
                break;
        }

        System.out.println("digite o numero da opção escolhida:");
        int escolhaAudio = 0;
        try {
            escolhaAudio = leitor.nextInt();
        escolhaAudio -= 1;
        } catch (Exception e) {
            System.out.println("Digite apenas numeros"); 
        }
        System.out.println("Opção escolhida: "+ listaMusicas.get(escolhaAudio).getNome());
        System.out.println(menu_play);



    }
}
