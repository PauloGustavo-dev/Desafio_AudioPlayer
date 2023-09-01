package br.com.alura.desafio_audioplayer.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.desafio_audioplayer.lista_audios.Listas;
import br.com.alura.desafio_audioplayer.produtos.Audio;

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

        List<Audio> listaMusicas = Listas.listaMusicas();

        List<Audio> listaPodcasts = Listas.listaPodcasts();

        List<Audio> listaEbooks = Listas.listaEbooks();

        List<Audio> listaGeneralizada = new ArrayList<>();

        System.out.println(escolhaTipoAudio + "s disponiveis : ");
        int i = 1;
        switch (escolhaTipoAudio) {
            case "musica":
                listaGeneralizada = listaMusicas;
                break;
            case "podcast":
                listaGeneralizada = listaPodcasts;
                break;
            case "ebook":
                listaGeneralizada = listaEbooks;
        }

        for (Audio audio : listaGeneralizada) {
            System.out.println(i + " - " + audio.getNome());
            i += 1;
        }
        System.out.println(i + " - Sair para o menu principal");
        int audioEscolhida = menuOpcoesAudio(i);
        int escolhaComando = 0;
        while (escolhaComando != 5) {
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
                5 - Voltar para lista de musicas
                digite o numero da opção escolhida:""";
        
        System.out.println(menu_audio);
        int escolhaMenu = leitor.nextInt();
        return escolhaMenu;
    }
}
