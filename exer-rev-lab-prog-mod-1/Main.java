import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static Vector<Habilidade> HABILIDADES = new Vector<>();
    static Vector<Pessoa> PESSOAS = new Vector<>();
    static int PESO_OBRIGATORIA = 3;
    static int PESO_IMPORTANTE = 2;

    // Serve para caso seja para comparar com outras notas, já que é reaproveitado o
    // código para imprimir também essa nota comparada
    static int NOTAS_COMPARAR = -1;

    public static void main(String[] args) {

        LeArquivoHabilidades(RetornaArquivo(
                "C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular\\exer-rev-lab-prog-mod-1\\file-habilidades.txt"),
                true);

        LeArquivoHabilidades(RetornaArquivo(
                "C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular\\exer-rev-lab-prog-mod-1\\file-pessoas.txt"),
                false);

        InterfaceUsuario(new Scanner(System.in));

    }

    /* Útil */

    private static String PegaHabilidade(Scanner teclado) {

        boolean habilidade_existe = false;
        int numero_tentatvias = 0;
        String habilidade = "";

        while (!habilidade_existe) {

            System.out.println("Digite o nome de uma habilidade: ");

            habilidade = teclado.nextLine();

            habilidade_existe = HabilidadeExiste(habilidade, numero_tentatvias);

            numero_tentatvias++;

        }

        return habilidade;

    }

    private static void FlushTeclado(Scanner teclado) {

        teclado.nextLine();

    }

    private static boolean HabilidadeExiste(String habilidade, int numero_tentatvias) {

        if (numero_tentatvias >= 2) {

            System.out.println("Lisata de habilidades: ");

            ImprimiVectorHabilidades();

        }

        for (int i = 0; i < HABILIDADES.size(); i++) {

            if (HABILIDADES.get(i).getNome_habilidade().equals(habilidade)) {
                return true;
            }

        }

        System.out.println("Habilidade não existe");

        return false;

    }

    private static int Imprimi_AND_RetornaMetodo1(String habilidade, int maior_nota, boolean is_imprimir) {

        if (is_imprimir) {
            System.out.println("O(s) melhor(es) candidato(s) para a vaga é(são): ");
        }

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade)) {

                    if (PESSOAS.get(i).getHabilidades().get(j).getPontuacao() > maior_nota && !is_imprimir) {
                        maior_nota = PESSOAS.get(i).getHabilidades().get(j).getPontuacao();
                    }

                    if (PESSOAS.get(i).getHabilidades().get(j).getPontuacao() == maior_nota && is_imprimir) {
                        System.out.println(PESSOAS.get(i).getNome_pessoa());
                    }

                }

            }

        }

        return maior_nota;

    }

    private static double Imprimi_AND_RetornaMetodo2(String habilidade_obrigatoria,
            String habilidade_importante, boolean is_imprimir, double melhor_media) {

        double somatoria_notas_pessoa = 0;

        if (is_imprimir) {
            System.out.println("O(s) melhor(es) candidato(s) para a vaga é(são): ");
        }

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade_obrigatoria)) {

                    somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao() * PESO_OBRIGATORIA;

                }

                if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade_importante)) {

                    somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao() * PESO_IMPORTANTE;

                }

            }

            double media_pessoa = somatoria_notas_pessoa / 2;

            if (media_pessoa > melhor_media && !is_imprimir) {
                melhor_media = media_pessoa;
            }

            if (media_pessoa == melhor_media && is_imprimir) {

                System.out.println(PESSOAS.get(i).getNome_pessoa());

            }

            somatoria_notas_pessoa = 0;

        }

        return melhor_media;

    }

    private static double Imprimi_AND_RetornaMetodo3(double melhor_media, boolean is_imprimir){

        if (is_imprimir) {
            System.out.println("O(s) melhor(es) candidato(s) para a vaga é(são): ");
        }

        double somatoria_notas_pessoa = 0;

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao();
                
            }

            double media_pessoa = somatoria_notas_pessoa / HABILIDADES.size();

            if(media_pessoa > melhor_media && !is_imprimir){

                melhor_media = media_pessoa;

            }

            if(media_pessoa == melhor_media && is_imprimir){

                System.out.println(PESSOAS.get(i).getNome_pessoa());

            }

            somatoria_notas_pessoa = 0;

        }

        return melhor_media;


    }

    /* Interface usuário */

    public static void InterfaceUsuario(Scanner teclado) {

        int escolha = -1;

        while (escolha != 0) {

            System.out.println("0 - Sair");
            System.out.println("1- Dada uma habilidade, mostra o melhor candidato: ");
            System.out.println("2- Dada uma habilidade importante e uma obrigatória, mostr o melhor candidato: ");
            System.out.println("3- Pessoa mais interessante para uma vaga");

            escolha = teclado.nextInt();

            FlushTeclado(teclado);

            switch (escolha) {

                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    DadaUmaHabilidade(teclado);
                    break;
                case 2:
                    DadaUmaHabilidadeObrigatoriaImportante(teclado);
                    break;
                case 3:
                    ConjuntoHabilidades();
                    break;
                default:
                    System.out.println("Informação inválida");
            }

        }

        teclado.close();

    }

    /* Métodos Usuário */

    private static void DadaUmaHabilidade(Scanner teclado) {

        String habilidade = PegaHabilidade(teclado);

        int maior_nota = Imprimi_AND_RetornaMetodo1(habilidade, NOTAS_COMPARAR, false);

        Imprimi_AND_RetornaMetodo1(habilidade, maior_nota, true);

    }

    private static void DadaUmaHabilidadeObrigatoriaImportante(Scanner teclado) {

        System.out.println("Habilidade Obrigatória: ");

        String habilidade_obrigatoria = PegaHabilidade(teclado);

        System.out.println("Habilidade importante: ");

        String habilidade_importante = PegaHabilidade(teclado);

        double melhor_media = Imprimi_AND_RetornaMetodo2(habilidade_obrigatoria, habilidade_importante,
                false, NOTAS_COMPARAR);

        Imprimi_AND_RetornaMetodo2(habilidade_obrigatoria, habilidade_importante, true, melhor_media);

    }

    private static void ConjuntoHabilidades(){

        double melhor_media = Imprimi_AND_RetornaMetodo3(NOTAS_COMPARAR, false);

        Imprimi_AND_RetornaMetodo3(melhor_media, true);

    }
    /* Testes */

    private static void ImprimiVectorPessoas() {

        for (int i = 0; i < PESSOAS.size(); i++) {

            Pessoa pessoa_mostrar = PESSOAS.get(i);

            System.out.print(pessoa_mostrar.getNome_pessoa() + ": ");

            for (int j = 0; j < pessoa_mostrar.getHabilidades().size(); j++) {

                System.out.print(pessoa_mostrar.getHabilidades().get(j).getPontuacao() + "-");

            }

            System.out.println();

        }

    }

    private static void ImprimiVectorHabilidades() {

        for (int i = 0; i < HABILIDADES.size(); i++) {
            System.out.println(HABILIDADES.get(i).getNome_habilidade());
        }

    }

    /* Operações Vector */

    private static void AddPessoaEmVectorPessoa(String linha) {

        String[] informacoes_linha = linha.split(";");

        Pessoa pessoa_adicionar = new Pessoa(informacoes_linha[0]);

        for (int i = 0; i < HABILIDADES.size(); i++) {

            int nota = Integer.parseInt(informacoes_linha[i + 1]);

            Habilidade habilidade_add = new Habilidade(HABILIDADES.get(i).getNome_habilidade(), nota);

            pessoa_adicionar.addHabilidade(habilidade_add);

        }

        PESSOAS.add(pessoa_adicionar);

    }

    private static void AddHabilidadeEmVectorHabilidade(String linha) {

        Habilidade habilidade_adicionar = new Habilidade(linha);

        HABILIDADES.add(habilidade_adicionar);

    }

    /* Arquivos */

    private static File RetornaArquivo(String path) {

        return new File(path);

    }

    private static void LeArquivoHabilidades(File arquivo, boolean is_habilidade) {

        try (FileReader fileReader = new FileReader(arquivo)) {

            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String linha = bufferedReader.readLine();

                while (linha != null) {

                    if (is_habilidade) {
                        AddHabilidadeEmVectorHabilidade(linha);
                    } else {
                        AddPessoaEmVectorPessoa(linha);
                    }

                    linha = bufferedReader.readLine();

                }

                bufferedReader.close();

            } catch (Exception e) {
                System.err.println(e);
            }

            fileReader.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
