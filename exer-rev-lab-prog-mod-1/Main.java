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
    static double NOTAS_COMPARAR = -1;

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

    private static double MetodoGeral(String habilidade_obrigatoria, String habilidade_importante, double var_nota,
            boolean is_imprimir, String metodo) {

        if (is_imprimir) {
            System.out.println("O(s) melhor(es) candidato(s) para a vaga é(são): ");
        }

        double somatoria_notas_pessoa = 0;

        for (int i = 0; i < PESSOAS.size(); i++) {

            for (int j = 0; j < HABILIDADES.size(); j++) {

                if (metodo.equals("Metodo1")) {

                    if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade_obrigatoria)) {

                        if (PESSOAS.get(i).getHabilidades().get(j).getPontuacao() > var_nota && !is_imprimir) {
                            var_nota = PESSOAS.get(i).getHabilidades().get(j).getPontuacao();
                        }

                        if (PESSOAS.get(i).getHabilidades().get(j).getPontuacao() == var_nota && is_imprimir) {
                            System.out.println(PESSOAS.get(i).getNome_pessoa());
                        }

                    }

                }

                if (metodo.equals("Metodo2")) {

                    if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade_obrigatoria)) {

                        somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao()
                                * PESO_OBRIGATORIA;

                    }

                    if (PESSOAS.get(i).getHabilidades().get(j).getNome_habilidade().equals(habilidade_importante)) {

                        somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao()
                                * PESO_IMPORTANTE;

                    }

                }

                if (metodo.equals("Metodo3")) {

                    if(PESSOAS.get(i).getHabilidades().get(j).getPontuacao() == 0){
                        somatoria_notas_pessoa -= 3;
                    }

                    somatoria_notas_pessoa += PESSOAS.get(i).getHabilidades().get(j).getPontuacao();
                }

            }

            if (metodo.equals("Metodo2") || metodo.equals("Metodo3")) {

                double media_pessoa = 0;

                if (metodo.equals("Metodo2")) {

                    media_pessoa = somatoria_notas_pessoa / 2;

                } else {

                    media_pessoa = somatoria_notas_pessoa / HABILIDADES.size();

                }

                if (media_pessoa > var_nota && !is_imprimir) {
                    var_nota = media_pessoa;
                }

                if (media_pessoa == var_nota && is_imprimir) {

                    System.out.println(PESSOAS.get(i).getNome_pessoa());

                }

                somatoria_notas_pessoa = 0;

            }

        }

        return var_nota;
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

        double melhor_nota = MetodoGeral(habilidade, "", NOTAS_COMPARAR, false, "Metodo1");

        MetodoGeral(habilidade, "", melhor_nota, true, "Metodo1");

    }

    private static void DadaUmaHabilidadeObrigatoriaImportante(Scanner teclado) {

        System.out.println("Habilidade Obrigatória: ");

        String habilidade_obrigatoria = PegaHabilidade(teclado);

        System.out.println("Habilidade importante: ");

        String habilidade_importante = PegaHabilidade(teclado);

        double melhor_media = MetodoGeral(habilidade_obrigatoria, habilidade_importante, NOTAS_COMPARAR, false,
                "Metodo2");

        MetodoGeral(habilidade_obrigatoria, habilidade_importante, melhor_media, true, "Metodo2");

    }

    private static void ConjuntoHabilidades() {

        double melhor_media = MetodoGeral("", "", NOTAS_COMPARAR, false, "Metodo3");

        MetodoGeral("", "", melhor_media, true, "Metodo3");

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
