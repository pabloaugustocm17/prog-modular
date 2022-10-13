from structures.Autor import Autor
from structures.Livro import Livro


class LivroFisico(Livro):
    
    def __init__(self, id : str, nome_livro : str, 
    valor_inical : float, autor_livro : Autor,
    quantidade_paginas : int, preco_adicional : float):
        
        super().__init__(id, nome_livro, valor_inical, autor_livro)
        self.quantidade_paginas = quantidade_paginas
        self.preco_adicional = preco_adicional
    
    # override
        
    def calculaPrecoLivro(self):
        
        preco_total_paginas : float = float(0.03) * int(self.quantidade_paginas)
        
        return preco_total_paginas + float(self.preco_adicional) + float(self.valor_inicial) +  float(self.direitos_autorais)
    
    # getter
    
    def getNome_livro(self):
        return super().getNome_livro()
    
    def getQuantidade_paginas(self):
        return self.quantidade_paginas