import java.util.Scanner;

public class Util{

    public static final Scanner teclado = new Scanner(System.in);

    public static void ImprimiMensagem(String mensagem){

        System.out.println(mensagem);

    }

    public static boolean VerificaData(String data) {

        char[] caracteres_data = data.toCharArray();

        if (caracteres_data[2] == '/' && caracteres_data[5] == '/' && caracteres_data.length == 10) {

            String[] dia_mes_ano = data.split("/");

            for (int i = 0; i < caracteres_data.length; i++) {

                if (i != 2 && i != 5) {

                    if (!((int) caracteres_data[i] > 47 && (int) caracteres_data[i] < 58)) {

                        System.out.println("A data suporta apenas números e '/', sendo esse formato DD/MM/AAAA: " + data);
                        return false;

                    }

                }

            }

            int dia = Integer.parseInt(dia_mes_ano[0]);
            int mes = Integer.parseInt(dia_mes_ano[1]);

            if (mes > 0 && mes < 12) {

                if (dia > 0 && dia < 32) {

                    if (mes == 2 && dia > 28) {
                        System.out.println("O mês de fevereiro de 2022 vai até o dia 28: " + data);
                        return false;
                    }

                    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                        System.out.println("Esse mês possuí 30 dias: " + data);
                        return false;
                    }

                } else {
                    System.out.println("Dia inválido: " + data);
                    return false;
                }

            } else {

                System.out.println("Mês inválido: " + data);
                return false;

            }

        } else {

            System.out.println("A data precisa do caractere '/': " + data);
            return false;

        }

        return true;

    }

    
}