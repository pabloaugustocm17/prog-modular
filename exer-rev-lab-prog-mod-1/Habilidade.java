class Habilidade {

    private String nome_habilidade;
    private double pontuacao;
    
    
    public Habilidade(String nome_habilidade) {
        
        this.nome_habilidade = nome_habilidade;
        this.pontuacao = 0.0;

    }


    public String getNome_habilidade() {
        return nome_habilidade;
    }


    public void setNome_habilidade(String nome_habilidade) {
        this.nome_habilidade = nome_habilidade;
    }


    public double getPontuacao() {
        return pontuacao;
    }


    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    
}
