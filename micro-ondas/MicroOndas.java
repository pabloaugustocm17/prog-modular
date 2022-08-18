import java.util.Scanner;

public class MicroOndas {

    private Tempo cronometro;
    private boolean is_fechado;
    private boolean is_funcionando;

    private void init() {
        this.cronometro = new Tempo();
        this.is_fechado = true;
        this.is_funcionando = false;
    }

    public MicroOndas() {
        init();
    }

    private void AdicionarTempo(int tempo_adicionar, String valor_atualizado) {

        switch (valor_atualizado) {

            case "Segundos":
                this.cronometro.AdicionaTempo(tempo_adicionar, "Segundos");
                break;

            case "Minutos":
                this.cronometro.AdicionaTempo(tempo_adicionar, "Minutos");
                break;

        }

    }

    private void MostraCronometro() {

        this.cronometro.ImprimiTempo();

    }

    public void PausarTempo() {

        if (cronometro.PausaTempo()) {

            System.out.println("Tempo pausado em: ");
            this.MostraCronometro();

        } else {
            System.out.println("O micro ondas está desligado");
        }

    }

    public void LigarMicroOndas(Scanner teclado) {

        if (!is_funcionando && is_fechado) {

            AdicionarTempo(teclado);
            is_funcionando = true;

        } else {
            MetodosUtil.ImprimiMensagem("O micro-ondas já está em funcionamento");
        }

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

        AdicionarTempo(segundos, "Segundos");
        AdicionarTempo(minutos, "Minutos");
        

    }
}
