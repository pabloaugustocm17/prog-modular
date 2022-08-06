import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static Vector<Integer> VECTOR_EXERCICIO_4 = new Vector<>();

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //ExercicioBasicos(teclado);

        //FlushTeclado(teclado);

        //ExerciciosAplicados(teclado);

        //UsoDeArquivos();

        teclado.close();
    }

    /* Menu Exercícios */

    /* Básicos */

    public static void ExercicioBasicos(Scanner teclado) {

        int[] vetor = CriaVetor(7, teclado);

        ImprimiVetor(vetor);

        vetor = InverteVetor(vetor);

        ImprimiVetor(vetor);

        int[] vetor_soma = CriaVetorSoma(vetor);

        ImprimiVetor(vetor_soma);

    }

    /* Aplicados */

    public static void ExerciciosAplicados(Scanner teclado) {

        LoopAteDataVerdadeira(teclado, false);
        LoopAteDataVerdadeira(teclado, true);

    }

    /* Uso de arquivos */

    public static void UsoDeArquivos() {

        LeArquivoVetor(PegaArquivo("C:\\Users\\pablo\\Documents\\GitHub\\prog-modular\\exer-rev-prog-mod-1\\file-exec5.txt"));

        Vector<Integer> vetor = CriaVectorSoma();

        ImprimiVector(vetor);
    }

    /* Utilitarios */

    private static void ImprimiVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {

            if (i + 1 != vetor.length) {

                System.out.print(vetor[i] + "-");

            } else {

                System.out.println(vetor[i]);
            }

        }

    }

    private static boolean isImpar(int tamanho_vetor) {

        if (tamanho_vetor % 2 == 0) {
            return false;
        } else {
            return true;
        }

    }

    private static void FlushTeclado(Scanner teclado) {

        teclado.nextLine();

    }

    private static String PegaData(Scanner teclado) {

        return teclado.nextLine();

    }

    private static void LoopAteDataVerdadeira(Scanner teclado, boolean is_imprimir_dia) {

        String data = PegaData(teclado);

        boolean data_valida = VerificaData(data);

        while (!data_valida) {

            System.out.println("Informe novamente a data: ");
            data = PegaData(teclado);
            data_valida = VerificaData(data);

        }

        System.out.println("Data válida");

        if (is_imprimir_dia) {

            int[][] calendario = PreencheMatrizCalendario();

            QualDia(data, calendario);

        }
    }

    private static int VerificaDia(int dia) {

        if (dia == 6) {
            return -1;
        } else {
            return dia;
        }

    }

    private static int[][] PreencheMatrizCalendario() {

        int[][] calendario = new int[12][31];

        int dia_semana = 6;

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 31; j++) {

                if (!(i == 1 && j > 27)) {

                    if (!((i == 3 || i == 5 || i == 8 || i == 10) && j > 29)) {

                        calendario[i][j] = dia_semana;

                        dia_semana = VerificaDia(dia_semana);

                        dia_semana++;

                    }

                }
            }

        }

        return calendario;

    }

    private static void ImprimiDiaSemana(int dia, int mes, int[][] calendario) {

        mes--;
        dia--;

        int dia_semana = calendario[mes][dia];

        switch (dia_semana) {

            case 0:
                System.out.println("Domingo");
                break;
            case 1:
                System.out.println("Segunda");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sexta");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("ERROR");
        }

    }

    private static void ImprimiMes(int mes) {

        mes--;

        switch (mes) {

            case 0:
                System.out.print("Janeiro");
                break;
            case 1:
                System.out.print("Fevereiro");
                break;
            case 2:
                System.out.print("Março");
                break;
            case 3:
                System.out.print("Abril");
                break;
            case 4:
                System.out.print("Maio");
                break;
            case 5:
                System.out.print("Junho");
                break;
            case 6:
                System.out.print("Julho");
                break;
            case 7:
                System.out.print("Agosto");
                break;
            case 8:
                System.out.print("Setembro");
                break;
            case 9:
                System.out.print("Outubro");
                break;
            case 10:
                System.out.print("Novembro");
                break;
            case 11:
                System.out.print("Dezembro");
                break;
            default:
                System.out.println("ERROR");

        }

    }

    private static File PegaArquivo(String path){

        return new File(path);

    }

    private static void PreencheVector(String linha){

        String[] numeros_linha = linha.split(";");

        for(int i = 0; i < numeros_linha.length; i++){

            VECTOR_EXERCICIO_4.add(Integer.parseInt(numeros_linha[i]));

        }


    }

    private static void ImprimiVector(Vector<Integer> vetor){

        for(int i = 0 ; i < vetor.size() ; i++){

            if(i+1 == vetor.size()){
                System.out.println(vetor.get(i));
            }else{
                System.out.print(vetor.get(i) + "-");
            }

        }

    }

    private static Vector<Integer> CriaVectorSoma(){

        boolean is_impar = isImpar(VECTOR_EXERCICIO_4.size());
        int tamanho_vetor_retornar = VECTOR_EXERCICIO_4.size() / 2;

        if (is_impar) {
            tamanho_vetor_retornar++;
        }

        Vector<Integer> vector_retornar = new Vector<>();

        for (int i = 0; i < VECTOR_EXERCICIO_4.size(); i += 2) {

            if (i + 1 < VECTOR_EXERCICIO_4.size()) {
                vector_retornar.add(VECTOR_EXERCICIO_4.get(i) + VECTOR_EXERCICIO_4.get(i+1));
            } else {
                vector_retornar.add(VECTOR_EXERCICIO_4.lastElement());
            }

        }

        return vector_retornar;


    }

    /* Exercício 1 */

    private static int[] CriaVetor(int tamanho_vetor, Scanner teclado) {

        int[] vetor_inteiro = new int[tamanho_vetor];

        for (int i = 0; i < tamanho_vetor; i++) {

            vetor_inteiro[i] = teclado.nextInt();

        }

        return vetor_inteiro;

    }

    private static int[] InverteVetor(int[] vetor_inteiro) {

        int[] vetor_auxiliar = new int[vetor_inteiro.length];
        int posicao_inversa = vetor_auxiliar.length - 1;

        for (int i = 0; i < vetor_inteiro.length; i++) {

            vetor_auxiliar[posicao_inversa] = vetor_inteiro[i];
            posicao_inversa--;

        }

        return vetor_auxiliar;

    }

    /* Exercício 2 */

    private static int[] CriaVetorSoma(int vetor_inteiro[]) {

        boolean is_impar = isImpar(vetor_inteiro.length);
        int tamanho_vetor_retornar = vetor_inteiro.length / 2;
        int posicao_atual_vetor = 0;

        if (is_impar) {
            tamanho_vetor_retornar++;
        }

        int[] vetor_retornar = new int[tamanho_vetor_retornar];

        for (int i = 0; i < vetor_inteiro.length; i += 2) {

            if (i + 1 < vetor_inteiro.length) {
                vetor_retornar[posicao_atual_vetor] = vetor_inteiro[i] + vetor_inteiro[i + 1];
                posicao_atual_vetor++;
            } else {
                vetor_retornar[posicao_atual_vetor] = vetor_inteiro[i];
            }

        }

        return vetor_retornar;

    }

    /* Exercício 3 */

    private static boolean VerificaData(String data) {

        char[] caracteres_data = data.toCharArray();

        if (caracteres_data[2] == '/' && caracteres_data[5] == '/') {

            String[] dia_mes_ano = data.split("/");

            for (int i = 0; i < caracteres_data.length; i++) {

                if (i != 2 && i != 5) {

                    if (!((int) caracteres_data[i] > 47 && (int) caracteres_data[i] < 58)) {

                        System.out.println("A data suporta apenas números e '/', sendo esse formato DD/MM/AAAA");
                        return false;

                    }

                }

            }

            int dia = Integer.parseInt(dia_mes_ano[0]);
            int mes = Integer.parseInt(dia_mes_ano[1]);

            if (mes > 0 && mes < 12) {

                if (dia > 0 && dia < 32) {

                    if (mes == 2 && dia > 28) {
                        System.out.println("O mês de fevereiro de 2022 vai até o dia 28");
                        return false;
                    }

                    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                        System.out.println("Esse mês possuí 30 dias");
                        return false;
                    }

                } else {
                    System.out.println("Dia inválido");
                    return false;
                }

            } else {

                System.out.println("Mês inválido");
                return false;

            }

        } else {

            System.out.println("A data precisa do caractere '/'");
            return false;

        }

        return true;

    }

    /* Exercício 4 */

    private static void QualDia(String data, int[][] calendario) {

        String[] data_separada = data.split("/");

        int dia = Integer.parseInt(data_separada[0]);
        int mes = Integer.parseInt(data_separada[1]);

        System.out.print(dia + " de ");
        ImprimiMes(mes);
        System.out.print(", ");
        ImprimiDiaSemana(dia, mes, calendario);

    }

    /* Exercício 5 */

    private static void LeArquivoVetor(File arquivo){

        try(FileReader fileReader = new FileReader(arquivo)){

            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){

                String linha = bufferedReader.readLine();

                while(linha != null){

                    PreencheVector(linha);

                    linha = bufferedReader.readLine();

                }

                bufferedReader.close();

            }catch(Exception e){
                System.out.println(e);
            }


            fileReader.close();

        }catch(Exception e){
            System.out.println(e);
        }

        

    }

}