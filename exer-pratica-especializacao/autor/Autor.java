package autor;

import java.util.List;

import livro.Livro;
import venda.Venda;

public class Autor {
    
    private String nome_autor;

    /* Métodos */

    public void imprimiAutor(List<Livro> livros, List<Venda> vendas){

        System.out.println("\nNome autor: " + this.nome_autor);

        if(livros.size() > 0){

            System.out.println("Livros do autor: ");

            for(Livro livro : livros){

                if(livro.getAutor_livro().equals(this)){

                    livro.imprimiLivro(false);
                    System.out.println("-------------------------");

                }    
            }
    
            System.out.println("Total arrecadado com direitos autorais: " 
            + this.retornaTotalArrecadadoDireitosAutorais(vendas) + "$");
            System.out.println("Total arrecadado: " + this.retornaTotalArrecadado(vendas) + "$\n");

        }else{
            System.out.println("\nSem livros registrados\n");
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

    public double retornaTotalArrecadadoDireitosAutorais(List<Venda> vendas){
    
        return totalArrecadadoDireitosAutorais(vendas);

    }

    public double retornaTotalArrecadado(List<Venda> vendas){

        return totalArrecadado(vendas);
    }

    public static Autor retornaAutor(List<Autor> autores, String nome_autor){

        for(Autor autor : autores){

            if(autor.getNome_autor().equals(nome_autor)){
                return autor;
            }

        }

        Autor autor_enviar = new Autor(nome_autor);
        autores.add(autor_enviar);
        return autor_enviar;

    }

    /* Métodos privados */

    /**
     * @return -> retorna o total arrecadado dos direitos autorais de um certo autor
     */
    private double totalArrecadadoDireitosAutorais(List<Venda> vendas){

        double total_direitos_autorais = 0;

        for(Venda venda : vendas){

            if(venda.getLivro_vendido().getAutor_livro().equals(this)){

                total_direitos_autorais += venda.getLivro_vendido().getDiretos_autorais() * 
                    venda.getQuantidade_vendas();

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
