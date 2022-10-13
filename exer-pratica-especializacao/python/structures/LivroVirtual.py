from .Autor import Autor
from .Livro import Livro

class LivroVirtual(Livro):
    
    def __init__(self, id : str, nome_livro : str, 
    valor_inicial : float, autor_livro : Autor):
        super().__init__(id, nome_livro, valor_inicial, autor_livro)
    
    # override
    
    def calculaPrecoLivro(self):
        return  float(self.valor_inicial) + float(self.direitos_autorais)