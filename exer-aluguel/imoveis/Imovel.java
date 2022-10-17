public abstract class Imovel {
    
    protected double valor_venda;
    protected String endereco;
    protected int ano_construcao;
    protected boolean isAreaLazer;
    protected boolean isCondominio;
    
    /* construtores */

    public void init(double valor_venda, String endereco, int ano_construcao, boolean isAreaLazer, boolean isCondominio){

        this.valor_venda = valor_venda;
        this.endereco = endereco;
        this.ano_construcao = ano_construcao;
        this.isAreaLazer = isAreaLazer;
        this.isCondominio = isCondominio;

    }

    public Imovel(double valor_venda, String endereco, int ano_construcao, boolean isAreaLazer, boolean isCondominio){
        init(valor_venda, endereco, ano_construcao, isAreaLazer, isCondominio);
    }

    /* abstratos */

    public abstract double calculaDesconto();

    public abstract double calculaAluguel();

    /* getters and setters */


}
