import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ExercicioBasicos(teclado);


    }

    /* Menu Exercícios */

    /* Básicos */

    public static void ExercicioBasicos(Scanner teclado){

        int[] vetor = CriaVetor(7, teclado);
        
        ImprimiVetor(vetor);

        vetor = InverteVetor(vetor);

        ImprimiVetor(vetor);

        int[] vetor_soma = CriaVetorSoma(vetor);

        ImprimiVetor(vetor_soma);


    }

    /* Utilitarios */

    private static void ImprimiVetor(int[] vetor){

        for(int i = 0; i < vetor.length; i++){

            if(i + 1 != vetor.length){

                System.out.print(vetor[i] + "-");

            }else{

                System.out.println(vetor[i]);
            }

            
        }

    }

    private static boolean isImpar(int tamanho_vetor){

        if(tamanho_vetor % 2 == 0){
            return false;
        }else{
            return true;
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

    /* Exercício 2 */

    private static int[] CriaVetorSoma(int vetor_inteiro[]){

        boolean is_impar = isImpar(vetor_inteiro.length);
        int tamanho_vetor_retornar = vetor_inteiro.length / 2;
        int posicao_atual_vetor = 0;
        
        if(is_impar){
            tamanho_vetor_retornar++;
        }

        int[] vetor_retornar = new int[tamanho_vetor_retornar];

        for(int i = 0; i < vetor_inteiro.length; i += 2){

            if(i + 1 < vetor_inteiro.length){
                vetor_retornar[posicao_atual_vetor] = vetor_inteiro[i] + vetor_inteiro[i+1];
                posicao_atual_vetor++;
            }else{
                vetor_retornar[posicao_atual_vetor] = vetor_inteiro[i];
            }

        }

        return vetor_retornar;



    }

}