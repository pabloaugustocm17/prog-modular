public class Funcionario {
    
    private String nome;
    private double salario_base;
    private double salario_bruto;
    private double salario_liquido;
    private boolean is_hora_extra;
    private boolean is_passagens;

    private void init(String nome, double salario_base, double salario_bruto, double salario_liquido, boolean is_hora_extra, boolean is_passagens){

        this.nome = nome;
        this.salario_base = salario_base;
        this.salario_bruto = salario_bruto;
        this.salario_liquido = salario_liquido;
        this.is_hora_extra = is_hora_extra;
        this.is_passagens = is_passagens;

    }

    public Funcionario(){

        init("", 0, 0, 0, false, false);

    }

    public Funcionario(String nome, double salario_base, double salario_bruto, double salario_liquido,
            boolean is_hora_extra, boolean is_passagens) {
        init(nome, salario_base, salario_bruto, salario_liquido, is_hora_extra, is_passagens);
    }

    



}
