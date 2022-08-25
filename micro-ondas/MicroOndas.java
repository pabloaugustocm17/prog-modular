import java.util.Scanner;

public class MicroOndas {

    private Tempo cronometro;
    private boolean is_fechado;
    private boolean is_funcionando;

    /* Construtor */

    private void init() {
        this.cronometro = new Tempo();
        this.is_fechado = true;
        this.is_funcionando = false;
    }

    public MicroOndas() {
        init();
    }

    /* Métodos Públicos */

    public void PausarTempo() {

        if (cronometro.PausaTempo()) {
            MetodosUtil.ImprimiMensagem("Tempo pausado em: ");
            this.MostraCronometro();
        } else {
            MetodosUtil.ImprimiMensagemErro("O Micro-Ondas está desligado");
        }

    }

    public void LigarMicroOndas(Scanner teclado) {

        if (!is_funcionando && is_fechado) {

            AdicionarTempo(teclado);
            is_funcionando = true;

        } else {
            MetodosUtil.ImprimiMensagemErro("O micro-ondas já está em funcionamento");
        }

    }

    public void DesligarMicroOndas() {

        this.cronometro.ZerarTempo();

    }

    public void AdicionaTempo(Scanner teclado){

        this.AdicionarTempo(teclado);
        
    }

    /* Métodos Privados */

    /**
     * @param tempo_adicionar -> envia o tempo a ser adicionado ao cronometro
     * @param valor_atualizado -> recebe qual unidade de tempo é para ser atualizada
     */
    private void AdicionarTempo(int tempo_adicionar, String valor_atualizado) {

        if(valor_atualizado.equals(MetodosUtil.SEGUNDOS)){
            this.cronometro.AdicionaTempo(tempo_adicionar, MetodosUtil.SEGUNDOS);
        }else if(valor_atualizado.equals(MetodosUtil.MINUTOS)){
            this.cronometro.AdicionaTempo(tempo_adicionar, MetodosUtil.MINUTOS);
        }

    }

    private void MostraCronometro() {

        this.cronometro.ImprimiTempo();

    }

    private void AdicionarTempo(Scanner teclado) {

        boolean verificacao = false;
        int minutos = 0;
        int segundos = 0;

        do {

            MetodosUtil.ImprimiMensagem("Informe o tempo que quer adicionar(mm:ss): ");

            String tempo = teclado.nextLine();

            char[] array_char = tempo.toCharArray();

            if (array_char.length == 5) {

                if (array_char[2] == ':') {

                    tempo = tempo.replaceAll("\\W", "");

                    try {

                        minutos = Integer.parseInt(tempo.substring(0, 2));
                        segundos = Integer.parseInt(tempo.substring(2, 4));

                        verificacao = true;

                    } catch (Exception e) {
                        MetodosUtil.ImprimiMensagemErro("Caractere inválido");
                    }

                } else {

                    MetodosUtil.ImprimiMensagemErro("Formato errado");

                }

            } else {

                MetodosUtil.ImprimiMensagemErro("Tamanho informado errado");

            }

        } while (!verificacao);

        AdicionarTempo(segundos, MetodosUtil.SEGUNDOS);
        AdicionarTempo(minutos, MetodosUtil.MINUTOS);

    }

}
