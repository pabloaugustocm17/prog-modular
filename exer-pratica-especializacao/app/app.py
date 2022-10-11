def main():
    interfaceUsuario()
    
def imprimiOpcoes():
    
    print("0 - Sair")
    print("1 - Localizar livros")
    print("2 - Localizar autores")
    print("3 - Registrar uma venda")    
    
# métodos usuários
    
def interfaceUsuario():
    
    while True:
        
        imprimiOpcoes()
        opcao = input()
        continuar = trataOpcoes(opcao)
        if(continuar == "encerrar"):
            break
        
def trataOpcoes(opcao):
    
    if(opcao == "0"):
        return "encerrar"
    
    if(opcao == "1"):
        localizar("livro")
        return "continuar"
        
    if(opcao == "2"):
        localizar("autor")
        return "continuar"    
    
    if(opcao == "3"):
       registraVenda()
       return "continuar"
                
# métodos privados

def leArquivos(path):
    
    arquivo = open(path, "r")
    
    for linha in arquivo:
        
        dados = linha.split()
        codigo_livro = dados[0]
        nome_livro = dados[1]
    
    arquivo.close()
    
def localizar(tipo):
    print(tipo)   
    
def registraVenda():
    print("A")         
        
if __name__ == '__main__':
    main()