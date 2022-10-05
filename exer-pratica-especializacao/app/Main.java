package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import autor.Autor;
import livro.Livro;
import venda.Venda;

public class Main{

    private final static Scanner teclado = new Scanner(System.in);
    private static List<Autor> autores = new ArrayList<>();
    public static List<Venda> vendas = new ArrayList<>();
    public static List<Livro> livros = new ArrayList<>();


    public static void main(String[] args) {
        
        leArquivos("","");
        interfaceUsuario();



    }

    /* Métodos Públicos */

    public static void interfaceUsuario(){

        String escolha;
        boolean continuar = true;

        do{

            imprimiOpcoes();
            escolha = teclado.nextLine();
            continuar = trataOpcoes(escolha);

        }while(continuar);

    }

    /* Métodos Privados */

    private static boolean trataOpcoes(String opcao){

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

            System.out.println("Informe o nomeque deseja buscar: ");
            nome = teclado.nextLine();

            if(tipo.equals("livro")){
                procuraLivro(nome);
            }else if(tipo.equals("autor")){
                procuraAutor(nome);
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
    private static Livro procuraLivro(String nome_livro){

        boolean isLivroAchado = false;
        
        for(Livro livro_analisar : livros){
            if(livro_analisar.getNome_livro().equals(nome_livro)){
                isLivroAchado = true;
                livro_analisar.imprimiLivro();
                return livro_analisar;
            }
        }

        if(!isLivroAchado){
            System.out.println("Livro não existe");
        }

        return null;

    }

    /* Busca autor */

    /**
     * @param nome_autor -> recebe o nome do autor à ser procurado
     */
    private static void procuraAutor(String nome_autor){

        boolean isAutorAchado = false;

        for(Autor autor_analisar : autores){
            if(autor_analisar.getNome_autor().equals(nome_autor)){
                isAutorAchado = true;
                autor_analisar.imprimiAutor();
                break;
            }
        }

        if(!isAutorAchado){
            System.out.println("Autors não existe");
        }

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
        Livro livro_vendido = procuraLivro(nome_livro);

        if(livro_vendido != null){
            
            System.out.println("Informe a quantidade de livros que será comprado: ");
            int quantidade_livros = teclado.nextInt();
            vendas.add(new Venda(quantidade_livros, livro_vendido));


        }else{
            System.out.println("Compra não pode ser realizada");
        }

    }
}