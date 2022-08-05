import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Exercicio1(teclado);


    }

    /* Menu Exercícios */

    public static void Exercicio1(Scanner teclado){

        int[] vetor = CriaVetor(6, teclado);
        
        ImprimiVetor(vetor);

        vetor = InverteVetor(vetor);

        ImprimiVetor(vetor);


    }

    /* Utilitarios */

    private static void ImprimiVetor(int[] vetor){

        for(int i = 0; i < vetor.length; i++){

            System.out.println(vetor[i]);
        }

    }

    /* Exercício 1 */

    private static int[] CriaVetor(int tamanho_vetor, Scanner teclado){

        int[] vetor_inteiro = new int[tamanho_vetor];

        for(int i = 0; i < tamanho_vetor; i++){

            vetor_inteiro[i] = teclado.nextInt();

        }

        return vetor_inteiro;


    }

    private static int[] InverteVetor(int[] vetor_inteiro){

        int[] vetor_auxiliar = new int[vetor_inteiro.length];
        int posicao_inversa = vetor_auxiliar.length - 1;

        for(int i = 0; i < vetor_inteiro.length; i++){

            vetor_auxiliar[posicao_inversa] = vetor_inteiro[i];
            posicao_inversa--;

        }

        return vetor_auxiliar;

    }


}