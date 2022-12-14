from xmlrpc.client import boolean
from abc import ABC, abstractmethod

from .Autor import Autor

class Livro(ABC):
    
    def __init__(self, id : str, nome_livro : str, 
    valor_inicial : float, autor_livro : Autor):
        
        self.id = id
        self.nome_livro = nome_livro
        self.valor_inicial = valor_inicial
        self.autor_livro = autor_livro
        self.direitos_autorais = float(valor_inicial) * float(0.08)
    
    # classe abstrata
    
    @abstractmethod
    def calculaPrecoLivro(self):
        pass    
    
    # métodos públicos
    
    def imprimiLivro(self, isNomeAutor : boolean):
        
        preco_livro = self.calculaPrecoLivro()
        
        print("Id:", self.id ,"\n")
        print("Nome Livro:", self.nome_livro ,"\n")
        print("Valor:", preco_livro,"$")
        
        if(isNomeAutor):
            nome_autor = self.autor_livro.getNome_autor()
            print("Nome autor:", nome_autor, "\n")
            
    # getters
    
    def getValor_inicial(self):
        return self.valor_inicial
    
    def getDireitos_autorais(self):
        return self.direitos_autorais
    
    def getNome_livro(self):
        return self.nome_livro
    
    def getAutor_livro(self):
        return self.autor_livro       
         
        
    