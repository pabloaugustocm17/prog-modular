package livro;

import autor.Autor;

public abstract class Livro{
    
    private String nome_livro;
    private double valor_inicial;
    private int quantidade_paginas;
    private Autor autor_livro;
    private double direitos_autorais;

    /* Métodos abstratos */


    /**
     * @return -> retorna o preco que o livro irá custar no final
     */
    public abstract double calculaPrecoLivro();

   
    /**
     * @param isNomeAutor -> caso seja para mostrar o nome do autor a variável é true;
     */
    public void imprimiLivro(boolean isNomeAutor){

        System.out.println("\nNome livro: " + this.nome_livro);
        System.out.println("Quantidade de páginas: " + this.quantidade_paginas);
        System.out.println("Valor: " + this.calculaPrecoLivro() + "$");

        if(isNomeAutor){
            System.out.println("Nome do autor: " + this.autor_livro.getNome_autor());
        }
    }

    /* Construtores */

    private void init(String nome_livro, double valor_inicial, int quantidade_paginas,
    Autor autor_livro){

        this.nome_livro = nome_livro;
        this.valor_inicial = valor_inicial;
        this.quantidade_paginas = quantidade_paginas;
        this.direitos_autorais = valor_inicial * 0.08;
        this.autor_livro = autor_livro;

    }

    public Livro(String nome_livro, double valor_inicial, int quantidade_paginas,
    Autor autor_livro){
        init(nome_livro, valor_inicial, quantidade_paginas, autor_livro);
    }


    /* Getters and Setters */

    public double getValor_inicial() {
        return this.valor_inicial;
    }

    public int getQuantidade_paginas() {
        return this.quantidade_paginas;
    }

    public double getDiretos_autorais(){
        return this.direitos_autorais;
    }
    
    public String getNome_livro(){
        return this.nome_livro;
    }
    
    public Autor getAutor_livro(){
        return this.autor_livro;
    }

}
