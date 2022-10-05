package autor;

import java.util.List;

import livro.Livro;
import venda.Venda;

public class Autor {
    
    private String nome_autor;

    /* Métodos */

    public void imprimiAutor(List<Livro> livros){

        System.out.println("Nome autor: " + this.nome_autor);
        System.out.println("Livros do autor: ");

        for(Livro livro : livros){

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

    /* Métodos públicos */

    public double retornaTotalArrecadadoDireitosAutorais(List<Livro> livros){
    
        return totalArrecadadoDireitosAutorais(livros);

    }

    public double retornaTotalArrecadado(List<Venda> vendas){

        return totalArrecadado(vendas);
    }

    /* Métodos privados */

    /**
     * @return -> retorna o total arrecadado dos direitos autorais de um certo autor
     */
    private double totalArrecadadoDireitosAutorais(List<Livro> livros){

        double total_direitos_autorais = 0;

        for(Livro livro : livros){

            if(livro.getAutor_livro().equals(this)){

                total_direitos_autorais += livro.getDiretos_autorais();

            }

        }

        return total_direitos_autorais;

    }

    /**
     * @return -> retorna o total arrecadado pelo autor
     */
    private double totalArrecadado(List<Venda> vendas){

        double total_arrecadado = 0;

        for(Venda venda : vendas){

            if(venda.getLivro_vendido().getAutor_livro().equals(this)){
                total_arrecadado += venda.getValor_venda();
            }

        }

        return total_arrecadado;

    }

}
