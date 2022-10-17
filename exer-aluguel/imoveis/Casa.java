public class Casa extends Imovel implements IConstantes {

    public Casa(double valor_venda, String endereco, int ano_construcao, boolean isAreaLazer, boolean isCondominio) {
        super(valor_venda, endereco, ano_construcao, isAreaLazer, isCondominio);
    }

    @Override
    public double calculaDesconto() {
        
        double desconto = 0;

        for(int i = 0; i < this.ano_construcao / 5 ; i++){
            if(desconto < desconto_maximo){
                desconto += desconto_idade_casa;
            }
        }

        return desconto;
    }

    @Override
    public double calculaAluguel() {
        return (this.valor_venda * valor_inicial_casa) * calculaDesconto();
    }
    
}
