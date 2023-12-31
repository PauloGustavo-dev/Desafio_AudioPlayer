package br.com.alura.desafio_audioplayer.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.desafio_audioplayer.lista_audios.Listas;
import br.com.alura.desafio_audioplayer.produtos.Audio;
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
                    menuEscolhaTipoAudio("musica");
                    break;
                case "2":
                    menuEscolhaTipoAudio("podcast");
                    break;
                case "3":
                    menuEscolhaTipoAudio("ebook");
                    break;
                case "4":
                    menuEscolhaTipoAudio("playlist");
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

    static void menuEscolhaTipoAudio(String escolhaTipoAudio) {

        List<Audio> listaMusicas = Listas.listaMusicas();

        List<Audio> listaPodcasts = Listas.listaPodcasts();

        List<Audio> listaEbooks = Listas.listaEbooks();

        List<Audio> listaGeneralizada = new ArrayList<>();

        List<Audio> minhaPlaylist = new ArrayList<>();

        System.out.println(escolhaTipoAudio + "s disponiveis : ");
        int i = 1;
        Scanner leitor = new Scanner(System.in);
        switch (escolhaTipoAudio) {
            case "musica":
                listaGeneralizada = listaMusicas;
                break;
            case "podcast":
                listaGeneralizada = listaPodcasts;
                break;
            case "ebook":
                listaGeneralizada = listaEbooks;
                break;
            case "playlist":
                boolean sairPlaylist = false;
                while (sairPlaylist == false){
                    System.out.println("Lista de musicas: ");
                    i=1;
                    for (Audio musica : listaMusicas) {
                        System.out.println(i + " - " + musica.getNome());
                        i += 1;
                    }
                    System.out.println(i + " - Sair para o menu principal");
                    System.out.println("Escolha qual opcao vc deseja adicionar a playlist");
                    int musicaPlaylist = leitor.nextInt();
                    if (musicaPlaylist == i){
                        menuPrincipal();
                    }
                    musicaPlaylist -= 1;

                    minhaPlaylist.add(listaMusicas.get(musicaPlaylist));
                    System.out.println(minhaPlaylist);
                }
                break;
        }

        for (Audio audio : listaGeneralizada) {
            System.out.println(i + " - " + audio.getNome());
            i += 1;
        }
        System.out.println(i + " - Sair para o menu principal");
        int audioEscolhida = menuOpcoesAudio(i);
        int escolhaComando = 0;
        while (escolhaComando != 6) {
            System.out.println("Opção escolhida: " + listaGeneralizada.get(audioEscolhida).getNome());
            escolhaComando = menuOpcaoMetodoObjeto();
            switch (escolhaComando) {
                case 1:
                    listaGeneralizada.get(audioEscolhida).play();
                    break;
                case 2:
                    double duracaoMusica = listaGeneralizada.get(audioEscolhida).getDuracaoEmMinutos();
                    System.out.println("Duração em minutos " + duracaoMusica + " Minutos");
                    break;
                case 3:
                    int totalReproducoes = listaGeneralizada.get(audioEscolhida).getTotalDeReproducoes();
                    System.out.println("Voce reproduziu " + totalReproducoes + " vezes");
                    break;
                case 4:
                    listaGeneralizada.get(audioEscolhida).curtir();
                    System.out.println("Voce curtiu " + listaGeneralizada.get(audioEscolhida).getCurtidas() + " vezes");
                    break;
                
                case 5:
                    Audio playback = listaGeneralizada.get(audioEscolhida);
                    if (playback instanceof Ebook ){
                        System.out.println("""
                        1 - Aumentar Velocidade
                        2 - Abaixar Velocidade
                        Selecione a opcao desejada: """);
                        int velocidade = leitor.nextInt();
                        if (velocidade == 1){
                            ((Ebook) playback).aumentarVelocidadeDeReproducao();
                        } else if (velocidade == 2){
                            ((Ebook) playback).abaixarVelocidadeDeReproducao();
                        } else {
                            System.out.println("opcao invalida");
                        }
                    } else if (playback instanceof Podcast){
                        System.out.println("""
                        1 - Aumentar Velocidade
                        2 - Abaixar Velocidade
                        Selecione a opcao desejada: """);
                        int velocidade = leitor.nextInt();
                        if (velocidade == 1){
                            ((Podcast) playback).aumentarVelocidadeDeReproducao();
                        } else if (velocidade == 2){
                            ((Podcast) playback).abaixarVelocidadeDeReproducao();
                        } else {
                            System.out.println("opcao invalida");
                        }
                    } else{
                        System.out.println("Não é possivel acelerar uma musica");
                        menuEscolhaTipoAudio(escolhaTipoAudio);
                    }
                    break;
                case 6:
                    menuEscolhaTipoAudio(escolhaTipoAudio);
                    break;
                default:
                    System.out.println("opcao invalida");
                    menuEscolhaTipoAudio(escolhaTipoAudio);
                    break;
            }
        }

    }

    public static int menuOpcoesAudio(int i) {
        System.out.println("Digite o numero da opção escolhida:");
        int escolhaAudio = 0;
        Scanner leitor = new Scanner(System.in);
        escolhaAudio = leitor.nextInt();
        if (escolhaAudio == i) {
            menuPrincipal();
        }
        escolhaAudio -= 1;
        return escolhaAudio;

    }

    public static int menuOpcaoMetodoObjeto() {
        Scanner leitor = new Scanner(System.in);
        String menu_audio = """

                1 - Play
                2 - Duracao
                3 - Numero de reproduções em sequencia
                4 - Curtir
                5 - Velocidade de reprodução
                6 - Voltar para lista de musicas
                digite o numero da opção escolhida:""";
        
        System.out.println(menu_audio);
        int escolhaMenu = leitor.nextInt();
        return escolhaMenu;
    }
}
