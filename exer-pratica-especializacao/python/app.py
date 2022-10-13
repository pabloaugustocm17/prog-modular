from asyncio.windows_events import NULL
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
    interfaceUsuario(livros, autores, vendas)
    
def imprimiOpcoes():
    
    print("0 - Sair")
    print("1 - Localizar livros")
    print("2 - Localizar autores")
    print("3 - Registrar uma venda")    
    
# métodos usuários
    
def interfaceUsuario(livros, autores, vendas):
    
    while True:
        
        imprimiOpcoes()
        opcao = input()
        continuar = trataOpcoes(opcao, livros , autores, vendas)
        if(continuar == "encerrar"):
            break
        
def trataOpcoes(opcao, livros, autores, vendas):
    
    if(opcao == "0"):
        return "encerrar"
    
    if(opcao == "1"):
        localizar("livro", livros = livros, autores = autores)
        return "continuar"
        
    if(opcao == "2"):
        localizar("autor", livros = livros, autores = autores)
        return "continuar"    
    
    if(opcao == "3"):
       registraVenda(livros = livros, vendas = vendas)
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
    
def localizar(tipo, livros, autores):
    
    isContinuar = True
    
    while(isContinuar):
        
        nome = str(input("Digite o nome que deseja buscar: "))
        
        if(tipo == "livro"):
            procuraLivro(nome_livro = nome,
                        isImprimir = True,
                        livros = livros)
        
        if(tipo == "autor"):
            procuraAutor(nome_autor = nome,
                        isImprimir = True,
                        autores = autores,
                        livros = livros)
        
        continuar = str(input("Deseja continuar procurando(S/N): "))
        
        if(continuar == "N"):
            isContinuar = False
            
def procuraLivro(nome_livro, isImprimir, livros):
     
    for livro in livros:
        if(livro.getNome_livro() == nome_livro):
            if(isImprimir == True):
                livro.imprimiLivro(True)
                return livro
    
def procuraAutor(nome_autor, isImprimir, autores, livros):
    
    for autor in autores:
        if(autor.getNome_autor() == nome_autor):
            if(isImprimir):
                autor.imprimiAutor(livros) 
                return autor   
    
def registraVenda(livros, vendas):
    
    nome = str(input("Informe o nome do livro que deseja comprar: "))
    livro : Livro = procuraLivro(nome_livro = nome,
                                 isImprimir = False,
                                 livros = livros)
    
    if(livro != NULL):
        
        quantidade_compra = int(input("Informe a quantidade de livros que sera comprado: "))
        vendas.append(Venda(quantidade_vendas = quantidade_compra,
                            livro_vendido = livro))
     
if __name__ == '__main__':
    main()