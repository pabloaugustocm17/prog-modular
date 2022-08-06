import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //ExercicioBasicos(teclado);
        ExerciciosAplicados(teclado);


        teclado.close();
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

    /* Aplicados */

    public static void ExerciciosAplicados(Scanner teclado){

        String data = PegaData(teclado);

        boolean data_valida = VerificaData(data);

        while(!data_valida){

            System.out.println("Informe novamente a data: ");
            data = PegaData(teclado);
            data_valida = VerificaData(data);
        
        }

        System.out.println("Data válida");

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

    private static void FlushTeclado(Scanner teclado){

        teclado.nextLine();

    }

    private static String PegaData(Scanner teclado){

        return teclado.nextLine();

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

    /* Exercício 3 */

    private static boolean VerificaData(String data){
            
        char[] caracteres_data = data.toCharArray();

        if(caracteres_data[2] == '/' && caracteres_data[5] == '/'){

            String[] dia_mes_ano = data.split("/");
            
            for(int i = 0; i < caracteres_data.length; i++){

                if(i != 2 && i != 5){

                    if(!((int)caracteres_data[i] > 47 && (int)caracteres_data[i] < 58)){

                        System.out.println("A data suporta apenas números e '/', sendo esse formato DD/MM/AAAA");
                        return false;

                    }

                }

            }

            int dia = Integer.parseInt(dia_mes_ano[0]);
            int mes = Integer.parseInt(dia_mes_ano[1]);

            if(mes > 0 && mes < 12){

                if(dia > 0 && dia < 32){

                    if(mes == 2 && dia > 28){
                        System.out.println("O mês de fevereiro de 2022 vai até o dia 28");
                        return false;
                    }

                    if((mes == 4 || mes == 6 || mes == 9 || mes == 11 ) && dia > 30 ){
                        System.out.println("Esse mês possuí 30 dias");
                        return false;
                    }


                }else{
                    System.out.println("Dia inválido");
                    return false;
                }

            }else{

                System.out.println("Mês inválido");
                return false;

            }

        }else{

            System.out.println("A data precisa do caractere '/'");
            return false;

        }

        return true;

    }
    

}