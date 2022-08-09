import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static Vector<Habilidade> HABILIDADES = new Vector<>();
    static Vector<Pessoa> PESSOAS = new Vector<>();

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

    private static void FlushTeclado(Scanner teclado){

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

    private static int RetornaNotaMelhorCandidatoDadaUmaHabilidade(String habilidade) {

        int maior_nota = -1;

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                if(PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade)){

                    if(PESSOAS.get(i).getHabilidades().get(j).getPontuacao() > maior_nota){
                        maior_nota = PESSOAS.get(i).getHabilidades().get(j).getPontuacao();
                    }

                }

            }

        }

        return maior_nota;

    }

    private static void ImprimiMelhorCandidatoDadaUmaHabilidade(String habilidade, int maior_nota){

        System.out.println("O(s) melhor(es) candidato(s) para a vaga é(são): ");

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                if(PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade)){

                    if(PESSOAS.get(i).getHabilidades().get(j).getPontuacao() == maior_nota){
                        System.out.println(PESSOAS.get(i).getNome_pessoa());
                    }

                }

            }

        }


    }

    /* Interface usuário */

    public static void InterfaceUsuario(Scanner teclado) {

        int escolha = -1;

        while (escolha != 0) {

            System.out.println("0 - Sair");
            System.out.println("1- Dada uma habilidade, mostra o melhor candidato: ");
            System.out.println("2-");
            System.out.println("3- ");

            escolha = teclado.nextInt();

            switch (escolha) {

                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    DadaUmaHabilidade(teclado);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Informação inválida");
            }

        }

        teclado.close();

    }

    /* Métodos Usuário */

    private static void DadaUmaHabilidade(Scanner teclado) {

        boolean habilidade_existe = false;
        int numero_tentatvias = 0;
        String habilidade = "";

        FlushTeclado(teclado);

        while (!habilidade_existe) {

            System.out.println("Digite o nome de uma habilidade: ");

            habilidade = teclado.nextLine();

            habilidade_existe = HabilidadeExiste(habilidade, numero_tentatvias);

            numero_tentatvias++;

        }

        int maior_nota = RetornaNotaMelhorCandidatoDadaUmaHabilidade(habilidade);

        ImprimiMelhorCandidatoDadaUmaHabilidade(habilidade, maior_nota);

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
