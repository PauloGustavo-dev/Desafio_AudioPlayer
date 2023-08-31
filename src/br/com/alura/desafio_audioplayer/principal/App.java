package br.com.alura.desafio_audioplayer.principal;

public class App {

    public static void main(String[] args) {
        boolean ativo = true;

        while(ativo){
            ativo = AppMenus.menuPrincipal();
        }

    }
}
