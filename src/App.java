// import br.com.alura.desafio_audioplayer.produtos.Audio;
// import br.com.alura.desafio_audioplayer.produtos.Ebook;
// import br.com.alura.desafio_audioplayer.produtos.Musica;
// import br.com.alura.desafio_audioplayer.produtos.Podcast;

import java.util.Scanner;

public class App {

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
                    System.out.println("musicas");
                    menuPlay("musica");
                    break;
                case "2":
                    System.out.println("podcast");
                    break;
                case "3":
                    System.out.println("Ebook");
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

    static void menuPlay(String opcao){
        switch (opcao) {
            case "musica":
                System.out.println("""
                    musicas disponiveis
                    play
                    duracao
                    cantor/banda
                    curtir
                    voltar para menu principal
                """);
                break;
            case "podcast/ebook" :
                System.out.println("""
                        epsodio/ livro
                        artista
                        velocidade de reproducap
                        duracao
                        play
                        curtir
                        voltar para menu principal
                        """);
                break;
            case "playlist":
                System.out.println("""
                    tipo de playlist(musica, podcast)
                    adicionar musica/ epsodio
                    duracao
                    quantidade inserida
                    play
                    curtir
                    remover
                    listar
                    artista/ cantores
                    tipodeconteudo/estilo musical
                    voltar para menu principal
                        """);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        boolean ativo = true;
        while(ativo){
            ativo = menuPrincipal();
        }

    }
}
