package venda;

import livro.Livro;

public class Venda {
    
    private int quantidade_vendas;
    private Livro livro_vendido;
    private double valor_venda;

    /* Construtores */

    private void init(int quantidade_vendas, Livro livro_vendido){

        this.quantidade_vendas = quantidade_vendas;
        this.livro_vendido = livro_vendido;
        this.valor_venda = this.quantidade_vendas * livro_vendido.calculaPrecoLivro();
    }

    public Venda(int quantidade_vendas, Livro livro_vendido){
        init(quantidade_vendas, livro_vendido);
    }

    /* Getters e Setters */

    public Livro getLivro_vendido(){
        return this.livro_vendido;
    }

    public double getValor_venda(){
        return this.valor_venda;
    }

}
