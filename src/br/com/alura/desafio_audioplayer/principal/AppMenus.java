package br.com.alura.desafio_audioplayer.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.desafio_audioplayer.lista_audios.Listas;
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

    static void menuEscolhaTipoAudio(String escolhaTipoAudio) {

        List<Musica> listaMusicas = Listas.listaMusicas();

        List<Podcast> listaPodcasts = Listas.listaPodcasts();

        List<Ebook> listaEbooks = Listas.listaEbooks();

        System.out.println(escolhaTipoAudio + "s disponiveis : ");
        int i = 1;
        switch (escolhaTipoAudio) {
            case "musica":
                for (Musica musica : listaMusicas) {
                    System.out.println(i + " - " + musica.getNome());
                    i += 1;
                }
                int musicaEscolhida = menuOpcoesAudio();
                int escolhaComando = 0 ;
                while (escolhaComando != 5) {
                    System.out.println("Opção escolhida: " + listaMusicas.get(musicaEscolhida).getNome());
                    escolhaComando = menuOpcaoMetodoObjeto(escolhaTipoAudio);
                    switch (escolhaComando) {
                        case 1:
                            listaMusicas.get(musicaEscolhida).play();
                            break;
                        case 2:
                            double duracaoMusica = listaMusicas.get(musicaEscolhida).getDuracaoEmMinutos();
                            System.out.println("Duração em minutos " + duracaoMusica + " Minutos");
                            break;
                        case 3:
                            int totalReproducoes = listaMusicas.get(musicaEscolhida).getTotalDeReproducoes();
                            System.out.println("Voce reproduziu " + totalReproducoes + " vezes");
                            break;
                        case 4:
                            listaMusicas.get(musicaEscolhida).curtir();
                            break;
                        case 5:
                            menuEscolhaTipoAudio("musica");
                            break;
                        default:
                            System.out.println("opcao invalida");
                            break;
                    }
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
    }

    public static int menuOpcoesAudio() {
        System.out.println("digite o numero da opção escolhida:");
        int escolhaAudio = 0;
        Scanner leitor = new Scanner(System.in);
        escolhaAudio = leitor.nextInt();
        escolhaAudio -= 1;
        return escolhaAudio;

    }

    public static int menuOpcaoMetodoObjeto(String tipoAudio) {
        Scanner leitor = new Scanner(System.in);
        String menu_musica = """

                1 - Play
                2 - Duracao
                3 - Numero de reproduções em sequencia 
                4 - Curtir
                5 - Voltar para lista de musicas
                digite o numero da opção escolhida:""";
        String menu_audio = """

                1 - Play
                2 - Numero de reproduções em sequencia
                4 - Curtir
                5 - Voltar para o menu principal
                digite o numero da opção escolhida:""";
        if (tipoAudio.equals("musica")) {
            System.out.println(menu_musica);
        } else {
            System.out.println(menu_audio);
        }
        int escolhaMenu = leitor.nextInt();
        return escolhaMenu;
    }

    public static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
