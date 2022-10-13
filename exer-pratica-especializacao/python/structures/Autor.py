class Autor:
    
    #construtor
    
    def __init__(self, nome_autor : str):
        self.nome_autor = nome_autor
    
    # getter
    
    def getNome_autor(self):
        return self.nome_autor
    
    # métodos públicos
    
    def imprimiAutor(self, livros):
        
        print("Nome autor:", self.nome_autor ,"")

        if(len(livros) > 0):
            
            print("Livros autor: ")
            
            for livro in livros:
                if(livro.getAutor_livro() == self):
                    livro.imprimiLivro(False)
                
    # métodos privados
    
    def retornaAutor(nome_autor : str, autores = []):
        
        for autor in (autores):
            
            if(autor.getNome_autor() == nome_autor):
                return autor
            
        
        autor_enviar = Autor(nome_autor = nome_autor)    
        
        autores.append(autor_enviar)
        
        return autor_enviar
          
        
        