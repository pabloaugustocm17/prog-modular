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

            System.out.println("0 - Sair");
            System.out.println("1 - Ligar");
            System.out.println("2 - Pausar");
            System.out.println("3 - Retomar");
            System.out.println("4 - Adicionar mais tempo");
            System.out.println("5 - Desligar");

            escolha = teclado.nextLine();

            switch (escolha) {

                case "0":
                    System.out.println("Saindo");
                    escolha = null;
                    break;

                case "1":
                    LigarMicroOndas(teclado);
                    break;

                case "2":
                    PausarTempo();
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;
                default:
                    System.out.println("Informações erradas");
            }

        }

    }

    /* Útil */

    /* Métodos MicroOndas */

    private static void LigarMicroOndas(Scanner teclado){

        MICRO_ONDAS.LigarMicroOndas(teclado);

    }

    private static void PausarTempo(){

        MICRO_ONDAS.PausarTempo();

    }

}