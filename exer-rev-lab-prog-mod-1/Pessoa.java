import java.util.Vector;

public class Pessoa {
    

    private String nome_pessoa;
    private Vector<Habilidade> habilidades;

    
    public Pessoa(String nome_pessoa) {

        this.nome_pessoa = nome_pessoa;
        this.habilidades = new Vector<>();

    }


    public String getNome_pessoa() {
        return nome_pessoa;
    }


    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }


    public Vector<Habilidade> getHabilidades() {
        return habilidades;
    }


    public void setHabilidades(Vector<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public void addHabilidade(Habilidade habilidade_add){

        this.habilidades.add(habilidade_add);

    }
    

    

}
