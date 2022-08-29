public class Veiculo {

    private String placa_veiculo;
    private String data_aquisicao;
    private double consumo_litro;
    private double km_total;
    private double combustivel_maximo;

    /* Construtores */

    private void init(String placa_veiculo, String data_aquisicao, double consumo_litro, double km_total,
            double combustivel_maximo) {

        this.placa_veiculo = placa_veiculo;
        this.data_aquisicao = data_aquisicao;
        this.consumo_litro = consumo_litro;
        this.km_total = km_total;
        this.combustivel_maximo = combustivel_maximo;

    }

    public Veiculo() {
        init("", "", 0, 0, 0);
    }

    public Veiculo(String placa_veiculo, double km_total, double combustivel_maximo) {
        init(placa_veiculo, "", 0, km_total, combustivel_maximo);
    }

    public Veiculo(String placa_veiculo, String data_aquisicao, double consumo_litro, double km_total,
            double combustivel_maximo) {
        init(placa_veiculo, data_aquisicao, consumo_litro, km_total, combustivel_maximo);
    }

    /* A */

    public String RegistraDataAquisicao() {

        Util.ImprimiMensagem("Informe a data de aquisição do veículo: ");
        String data_aquisicao = Util.teclado.nextLine();
        boolean data_correta = Util.VerificaData(data_aquisicao);

        while (!data_correta) {

            Util.ImprimiMensagem("Informe novamente a data de aquisição de forma correta: ");
            data_aquisicao = Util.teclado.nextLine();
            data_correta = Util.VerificaData(data_aquisicao);

        }

        setDataAquisicao(data_aquisicao);

        return data_aquisicao;

    }

    private void setDataAquisicao(String data_aquisicao) {

        this.data_aquisicao = data_aquisicao;

    }

    /* B */

    public double RegistraConsumoLitro() {

        Util.ImprimiMensagem("Informe o consumo por litro do veículo: ");

        try {

            double consumo_litro = Util.teclado.nextDouble();
            setConsumoLitro(consumo_litro);
            return consumo_litro;

        } catch (Exception e) {

            Util.ImprimiMensagem("ERROR" + e.getMessage());
            return 0;

        }

    }

    private void setConsumoLitro(double consumo_litro) {

        this.consumo_litro = consumo_litro;

    }

    /* C */

    public double getKmtotal() {
        return this.km_total;
    }

    /* D */

    public void CalcularKmMedia() {

        Util.ImprimiMensagem("Informe a quilometragem da rota: ");
        double rota = Util.teclado.nextDouble();

        RetornaMediaRota(rota);

    }

    private double RetornaMediaRota(double rota) {

        return Math.floor(rota / consumo_litro);

    }

    /* E */

    public void CalcularTanqueCheio() {

        Util.ImprimiMensagem("Informe o preço do combustível: ");
        double preco_combustivel = Util.teclado.nextDouble();

        RetornaValorTanqueCheio(preco_combustivel);
    }

    private double RetornaValorTanqueCheio(double preco_combustivel) {

        return Math.floor(this.combustivel_maximo * preco_combustivel);

    }

    /* Util */

    public void ImprimiVeiculo() {
        Util.ImprimiMensagem("Placa veiculo: " + this.placa_veiculo);
        Util.ImprimiMensagem("Data de aquisição: " + this.data_aquisicao);
        Util.ImprimiMensagem("Consumo por litro: " + this.consumo_litro);
        Util.ImprimiMensagem("Quilometragem atual: " + this.km_total);
        Util.ImprimiMensagem("Cobustível máximo do tanque: " + this.combustivel_maximo);
    }

    public static Veiculo CriaVeiculo() {

        Util.ImprimiMensagem("Informe a placa do veiculo: ");
        String placa_veiculo = Util.teclado.nextLine();
        Util.ImprimiMensagem("Informe a quilometragem atual do veiculo: ");
        double km_total = Util.teclado.nextDouble();
        Util.ImprimiMensagem("Informe a quantidade de combustível máximo do veículo: ");
        double combustivel_maximo = Util.teclado.nextDouble();

        Veiculo veiculo = new Veiculo(placa_veiculo, km_total, combustivel_maximo);

        return veiculo;

    }
}
