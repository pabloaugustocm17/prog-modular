from structures.Livro import Livro
from structures.LivroFisico import LivroFisico
from structures.venda import Venda
from structures.LivroVirtual import LivroVirtual
from structures.Autor import Autor


def main():
    
    autores : Autor = []
    livros : Livro = []
    vendas : Venda = []
    
    leArquivos("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular" +
         "\\exer-pratica-especializacao\\resources\\LIVROS_PM.txt", autores, livros, vendas)
    interfaceUsuario(livros)
    
def imprimiOpcoes():
    
    print("0 - Sair")
    print("1 - Localizar livros")
    print("2 - Localizar autores")
    print("3 - Registrar uma venda")    
    
# métodos usuários
    
def interfaceUsuario(livros):
    
    while True:
        
        imprimiOpcoes()
        opcao = input()
        continuar = trataOpcoes(opcao, livros)
        if(continuar == "encerrar"):
            break
        
def trataOpcoes(opcao, livros):
    
    if(opcao == "0"):
        return "encerrar"
    
    if(opcao == "1"):
        localizar("livro", livros = livros)
        return "continuar"
        
    if(opcao == "2"):
        localizar("autor")
        return "continuar"    
    
    if(opcao == "3"):
       registraVenda()
       return "continuar"
                
# métodos privados

def leArquivos(path, autores, livros, vendas):
    
    arquivo = open(path, "r")
    
    for linha in arquivo:
                
        dados = linha.split(";")
        codigo_livro : str = dados[0]
        nome_livro : str = dados[1]
        autor_livro : Autor = Autor.retornaAutor(nome_autor = dados[2], autores = autores)
        preco_base : float = dados[4]
        
        if(dados[3] == "D"):
            copias_vendidas : int = dados[5]
            livro : LivroVirtual = LivroVirtual(id = codigo_livro, 
                                                nome_livro = nome_livro,
                                                valor_inicial = preco_base,
                                                autor_livro = autor_livro,)
            livros.append(livro)
        
        if(dados[3] == "F"):
            
            preco_adicional : float = dados[5]
            copias_vendidas : int = dados[6]  
            quantidade_vendas : int = dados[7]
            
            livro : LivroFisico = LivroFisico(id = codigo_livro,
                                              nome_livro = nome_livro, 
                                              valor_inical = preco_base,
                                              autor_livro = autor_livro,
                                              quantidade_paginas = copias_vendidas,
                                              preco_adicional = preco_adicional)
            
            livros.append(livro)
            vendas.append(Venda(quantidade_vendas = quantidade_vendas, 
                                livro_vendido = livro))
    
    
    arquivo.close()
    
def localizar(tipo, livros):
    
    isContinuar = True
    
    while(isContinuar):
        
        nome = str(input("Digite o nome que deseja buscar: "))
        
        procuraLivro(nome_livro = nome,
                     isImprimir = True,
                     livros = livros)
        
        continuar = str(input("Deseja continuar procurando(S/N): "))
        
        if(continuar == "N"):
            isContinuar = False
            
def procuraLivro(nome_livro, isImprimir, livros):
    
    
    for livro in livros:
        if(livro.getNome_livro() == nome_livro):
            if(isImprimir == True):
                livro.imprimiLivro(True)
    
    

def registraVenda():
    print("A")         
        
if __name__ == '__main__':
    main()