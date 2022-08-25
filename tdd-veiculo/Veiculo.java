public class Veiculo {
    
    private String placa_veiculo;
    private String data_aquisicao;
    private double consumo_litro;
    private double km_total;

    private void init(String placa_veiculo, String data_aquisicao, double consumo_litro, double km_total){

        this.placa_veiculo = placa_veiculo;
        this.data_aquisicao = data_aquisicao;
        this.consumo_litro = consumo_litro;
        this.km_total = km_total;

    }

    public Veiculo(){
        init("", "", 0, 0);
    }
    
    public Veiculo(String placa_veiculo, String data_aquisicao, double consumo_litro, double km_total){
        init(placa_veiculo, data_aquisicao, consumo_litro, km_total);
    }

    public static Veiculo CriaVeiculo(){

        Main.ImprimiMensagem("Informe a placa do veiculo: ");
        String placa_veiculo = Main.teclado.nextLine();
        Main.ImprimiMensagem("Informe a data de aquisicao do veiculo: ");
        String data_aquisicao = Main.teclado.nextLine();
        Main.ImprimiMensagem("Informe o consumo por litro do veiculo: ");
        double consumo_litro = Main.teclado.nextDouble();
        Main.ImprimiMensagem("Informe a quilometragem atual do veiculo: ");
        double km_total = Main.teclado.nextDouble();

        Veiculo veiculo = new Veiculo(placa_veiculo, data_aquisicao, consumo_litro, km_total);

        return veiculo;

    }

}
