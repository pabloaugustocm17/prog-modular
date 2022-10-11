from livro.livro import Livro

class Venda:
    
    def __init__(self, quantidade_vendas : int, livro_vendido : Livro):
        
        valor_livro : float = livro_vendido.calculaPrecoLivro()
        
        self.quantidade_vendas = quantidade_vendas
        self.livro_vendido = livro_vendido
        self.valor_venda : float = self.quantidade_vendas * valor_livro
    
    # getters
    
    def getLivro_vendido(self):    
        return self.livro_vendido
    
    def getValor_venda(self):
        return self.valor_venda
    
    def getQuantidade_vendas(self):
        return self.quantidade_vendas