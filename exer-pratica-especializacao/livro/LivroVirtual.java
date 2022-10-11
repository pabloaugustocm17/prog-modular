package livro;

import autor.Autor;

public class LivroVirtual extends Livro {

    public LivroVirtual(String id, String nome_livro, double valor_inicial, Autor autor_livro) {
        super(id, nome_livro, valor_inicial, autor_livro);
    }

    @Override
    public double calculaPrecoLivro() {

        return this.getValor_inicial() + this.getDiretos_autorais();
    
    }

    
}
