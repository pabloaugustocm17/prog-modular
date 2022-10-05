package livro;

import autor.Autor;

public class LivroVirtual extends Livro {

    public LivroVirtual(String nome_livro, double valor_inicial, int quantidade_paginas, Autor autor_livro) {
        super(nome_livro, valor_inicial, quantidade_paginas, autor_livro);
    }

    @Override
    public double calculaPrecoLivro() {

        return this.getValor_inicial() + this.getDiretos_autorais();
    
    }

    
}
