package livro;

import autor.Autor;

public class LivroFisico extends Livro {

    public LivroFisico(String nome_livro, double valor_inicial, int quantidade_paginas, Autor autor_livro) {
        super(nome_livro, valor_inicial, quantidade_paginas, autor_livro);
    }


    private final double preco_paginas = 0.03;
    private double preco_adicional;


    @Override
    protected double calculaPrecoLivro() {
        
        double preco_total_paginas = preco_paginas * this.getQuantidade_paginas();

        return preco_total_paginas + this.preco_adicional + this.getValor_inicial() + 
        this.getDiretos_autorais();
    }

   
}
