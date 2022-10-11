from autor.Autor import Autor
from livro.livro import Livro

class LivroVirtual(Livro):
    
    def __init__(self, id : str, nome_livro : str, 
    valor_inical : float, autor_livro : Autor):
        super().__init__(id, nome_livro, valor_inical, autor_livro)
    
    # override
    
    def calculaPrecoLivro(self):
        return self.valor_inicial + self.direitos_autorais