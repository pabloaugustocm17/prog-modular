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
                    System.out.println("Informações erradas");
            }

        }

    }

    



}