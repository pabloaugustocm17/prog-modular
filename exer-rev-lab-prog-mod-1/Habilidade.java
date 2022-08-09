class Habilidade {

    private String nome_habilidade;
    private int pontuacao;
    
    
    public Habilidade(String nome_habilidade) {
        
        this.nome_habilidade = nome_habilidade;
        this.pontuacao = 0;

    }

    public Habilidade(String nome_habilidade, int pontuacao) {
        
        this.nome_habilidade = nome_habilidade;
        this.pontuacao = pontuacao;

    }


    public String getNome_habilidade() {
        return nome_habilidade;
    }


    public void setNome_habilidade(String nome_habilidade) {
        this.nome_habilidade = nome_habilidade;
    }


    public int getPontuacao() {
        return pontuacao;
    }


    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    
}
