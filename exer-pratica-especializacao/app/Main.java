package app;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import autor.Autor;
import livro.Livro;
import livro.LivroFisico;
import livro.LivroVirtual;
import venda.Venda;

public class Main{

    private final static Scanner teclado = new Scanner(System.in, "UTF-8");
    private static List<Autor> autores = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        
        leArquivos("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular" +
         "\\exer-pratica-especializacao\\resources\\LIVROS_PM.txt");


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

    /**
     * @param opcao -> recebe a opção que o usuário escolheu para o app
     * @return -> retorna true caso seja para o programa continuar executando e false para caso seja para
     * finalizar
     * @throws InterruptedException
     * @throws IOException
     */
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
     * 
     * Este método é responsável por ler os arquivos e salvar em uma lista de livros ou autores
     * @throws FileNotFoundException
     * 
     */
    private static void leArquivos(String path) throws FileNotFoundException{
        
        FileInputStream file = new FileInputStream(path);

        try(InputStreamReader fileReader = new InputStreamReader(file, "UTF-8")){

            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){

                String linha = bufferedReader.readLine();

                while(linha != null){

                    System.out.println(linha);

                    String[] dados = linha.split(";");
                    
                    String codigo_livro = dados[0];
                    String nome_livro = dados[1];
                    Autor autor_livro = Autor.retornaAutor(autores, dados[2]);
                    String preco_base = dados[4];

                    autores.add(autor_livro);

                    if(dados[3].equals("D")){

                        String copias_vendidas = dados[5];

                        LivroVirtual livro = new LivroVirtual(codigo_livro, nome_livro, Double.parseDouble(preco_base), autor_livro);

                        livros.add(livro);
                        vendas.add(new Venda(Integer.parseInt(copias_vendidas), livro));
                        
                    }else if(dados[3].equals("F")){

                        String preco_adicional = dados[5];
                        String copias_vendidas = dados[6];
                        String quantidade_paginas = dados[7];
                        
                        LivroFisico livro = new LivroFisico(codigo_livro, nome_livro,
                        Double.parseDouble(preco_base), Integer.parseInt(quantidade_paginas), autor_livro, 
                        Double.parseDouble(preco_adicional));

                        livros.add(livro);
                        vendas.add(new Venda(Integer.parseInt(copias_vendidas), livro));

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
     * @param isImprimir -> define se é necessário imprimir o livro ou não
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
     * @param isImprimir -> define se é necessário imprimir o autor ou não
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

        System.out.println("Autor não existe");

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