package autor;

import app.Main;
import livro.Livro;
import venda.Venda;

public class Autor {
    
    private String nome_autor;

    /* Métodos */

    public void imprimiAutor(){

        System.out.println("Nome autor: " + this.nome_autor);
        System.out.println("Livros do autor: ");

        for(Livro livro : Main.livros){

            livro.imprimiLivro();
            System.out.println("-------------------------");

        }

    }

    /* Construtores */

    private void init(String nome_autor){

        this.nome_autor = nome_autor;

    }

    public Autor(String nome_autor){
        init(nome_autor);
    }

    /* Getters and Setters */

    public String getNome_autor(){
        return this.nome_autor;
    }

    /* Métodos privados */

    /**
     * @return -> retorna o total arrecadado dos direitos autorais de um certo autor
     */
    private double totalArrecadadoDireitosAutorais(){

        double total_direitos_autorais = 0;

        for(Livro livros : Main.livros){

            if(livros.getAutor_livro().equals(this)){

                total_direitos_autorais += livros.getDiretos_autorais();

            }

        }

        return total_direitos_autorais;

    }

    /**
     * @return -> retorna o total arrecadado pelo autor
     */
    private double totalArrecadado(){

        double total_arrecadado = 0;

        for(Venda vendas : Main.vendas){

            if(vendas.getLivro_vendido().getAutor_livro().equals(this)){
                total_arrecadado += vendas.getValor_venda();
            }

        }

        return total_arrecadado;

    }

}
