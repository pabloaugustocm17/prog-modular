import java.util.Scanner;

public class Main {

    static MicroOndas MICRO_ONDAS = new MicroOndas();

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        InterfaceUsuario(teclado);

        teclado.close();
    }

    public static void InterfaceUsuario(Scanner teclado) {

        String escolha = "";

        while (escolha != null) {

            MetodosUtil.ImprimiMensagem("0 - Sair");
            MetodosUtil.ImprimiMensagem("1 - Ligar");
            MetodosUtil.ImprimiMensagem("2 - Pausar");
            MetodosUtil.ImprimiMensagem("3 - Retomar");
            MetodosUtil.ImprimiMensagem("4 - Adicionar mais tempo");
            MetodosUtil.ImprimiMensagem("5 - Desligar");

            escolha = teclado.nextLine();

            switch (escolha) {

                case "0":
                    MetodosUtil.ImprimiMensagem("Saindo");
                    escolha = null;
                    break;

                case "1":
                    MICRO_ONDAS.LigarMicroOndas(teclado);
                    break;

                case "2":
                    MICRO_ONDAS.PausarTempo();
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":
                    MICRO_ONDAS.DesligarMicroOndas();
                    break;
                default:
                    MetodosUtil.ImprimiMensagemErro("Informações erradas");
            }

        }

    }

    



}