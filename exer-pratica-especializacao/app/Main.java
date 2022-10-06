package app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import autor.Autor;
import livro.Livro;
import livro.LivroFisico;
import livro.LivroVirtual;
import venda.Venda;

public class Main{

    private final static Scanner teclado = new Scanner(System.in);
    private static List<Autor> autores = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        
        leArquivos("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular" +
         "\\exer-pratica-especializacao\\resources\\autores.txt",
         "autor");

        leArquivos("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\" +
        "prog-modular\\exer-pratica-especializacao\\resources\\livros.txt",
        "livro");

        interfaceUsuario();

    }

    /* Métodos Públicos */

    public static void interfaceUsuario() throws InterruptedException, IOException{

        String escolha;
        boolean continuar = true;

        do{

            imprimiOpcoes();
            escolha = teclado.nextLine();
            continuar = trataOpcoes(escolha);

        }while(continuar);

    }

    /* Métodos Privados */

    private static boolean trataOpcoes(String opcao) throws InterruptedException, IOException{

        //Limpar Tela
        limparTela();

        switch(opcao){

            case "0":
                return false;
            case "1":
                localizar("livro");
                return true;
            case "2":
                localizar("autor");
                return true;
            case "3":
                registraVenda();
                return true;
            default:
                System.out.println("Informação inválida");
                return true;
        }
    }

    /**
     * @param path -> informa o caminho do arquivo a ser lido
     * @param tipo -> informa o tipo de arquivos que será lido, sendo do tipo 'autor' ou 'livro'
     * 
     * Este método é responsável por ler os arquivos e salvar em uma lista de livros ou autores
     * 
     */
    private static void leArquivos(String path, String tipo){
        
        File file = new File(path);

        try(FileReader fileReader = new FileReader(file)){

            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){

                String linha = bufferedReader.readLine();

                while(linha != null){

                    if(tipo.equals("autor")){

                        autores.add(new Autor(linha));

                    }else if(tipo.equals("livro")){

                        String[] dados = linha.split(";");

                        String nome_livro = dados[0];
                        double valor_inical = Double.parseDouble(dados[1]);
                        int quantidade_paginas = Integer.parseInt(dados[2]);
                        String nome_autor = dados[3];
                        String tipo_livro = dados[4];

                        Autor autor = procuraAutor(nome_autor, false);

                        if(autor != null){
                            if(tipo_livro.equals("Fisico")){

                                double preco_adicional = Double.parseDouble(dados[5]);

                                livros.add(new LivroFisico(nome_livro, valor_inical, quantidade_paginas
                                , autor, preco_adicional));

                            }else if(tipo_livro.equals("Virtual")){

                                livros.add(
                                    new LivroVirtual(nome_livro, valor_inical, quantidade_paginas
                                    , autor));

                            }
                        }else{
                            System.out.println("Autor inválido");
                        }
                    }

                    linha = bufferedReader.readLine();

                }



            }catch(Exception e){
                System.out.println(e);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        


    }

    /**
     * 
     * Este método mostra as oções que o usuário tem.
     * 
     */
    private static void imprimiOpcoes(){
        System.out.println("0 - Sair");
        System.out.println("1 - Localizar livros");
        System.out.println("2 - Localizar autores");
        System.out.println("3 - Registrar uma venda");
    }

    /* Busca em livro */

    /**
     * 
     *  Método para localizar livro ou autor
     * 
     */
    private static void localizar(String tipo){

        String nome;
        String continuar;
        boolean isContinuar = false;

        do{

            System.out.println("Informe o nome que deseja buscar: ");
            nome = teclado.nextLine();

            if(tipo.equals("livro")){
                procuraLivro(nome, true);
            }else if(tipo.equals("autor")){
                procuraAutor(nome,true);
            }

            System.out.println("Deseja procurar outro (digite S/N): ");
            continuar = teclado.nextLine();

            if(continuar.equals("S")){
                isContinuar = true;
            }else{
                isContinuar = false;
            }

        }while(isContinuar);
    }


    /**
     * @param nome_livro -> recebe o nome do livro à ser procurado
     */
    private static Livro procuraLivro(String nome_livro, boolean isImprimir){

        for(Livro livro_analisar : livros){
            if(livro_analisar.getNome_livro().equals(nome_livro)){
                if(isImprimir){
                    livro_analisar.imprimiLivro(true);
                }
                return livro_analisar;
            }
        }

       
        System.out.println("Livro não existe");
        

        return null;

    }

    /* Busca autor */

    /**
     * @param nome_autor -> recebe o nome do autor à ser procurado
     */
    private static Autor procuraAutor(String nome_autor, boolean isImprimir){

        for(Autor autor_analisar : autores){
            if(autor_analisar.getNome_autor().equals(nome_autor)){
                
                if(isImprimir){
                    autor_analisar.imprimiAutor(livros, vendas);
                }

                return autor_analisar;
            }
        }

        System.out.println("Autors não existe");

        return null;
    }

    /* Venda para livro */

    /**
     * 
     * Registra venda de um certo livro
     * 
     */
    private static void registraVenda(){

        System.out.println("Informe o nome do livro que deseja comprar: ");
        String nome_livro = teclado.nextLine();
        Livro livro_vendido = procuraLivro(nome_livro, false);

        if(livro_vendido != null){
            
            System.out.println("Informe a quantidade de livros que será comprado: ");
            int quantidade_livros = teclado.nextInt();
            vendas.add(new Venda(quantidade_livros, livro_vendido));
            teclado.nextLine();

        }else{
            System.out.println("Compra não pode ser realizada");
        }

    }

    /* Útil */

    /**
     * 
     * Método para limpar a tela
     * 
     */
    private static void limparTela() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}