import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class Main {

    static Vector<Habilidade> HABILIDADES = new Vector<>();
    static Vector<Pessoa> PESSOAS = new Vector<>();

    public static void main(String[] args) {
        
        LeArquivoHabilidades(RetornaArquivo("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular\\exer-rev-lab-prog-mod-1\\file-habilidades.txt"), true);

        LeArquivoHabilidades(RetornaArquivo("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\prog-modular\\exer-rev-lab-prog-mod-1\\file-pessoas.txt"), false);


    }

    /* Testes */

    private static void ImprimiVectorPessoas(){

        for(int i = 0; i < PESSOAS.size(); i++){

            Pessoa pessoa_mostrar = PESSOAS.get(i);

            System.out.print(pessoa_mostrar.getNome_pessoa() + ": ");

            for(int j = 0; j < pessoa_mostrar.getHabilidades().size(); j++){

                System.out.print(pessoa_mostrar.getHabilidades().get(j).getPontuacao() + "-");

            }

            System.out.println();

        }

    }

    private static void ImprimiVectorHabilidades(){

        for(int i = 0; i < HABILIDADES.size(); i++){
            System.out.println(HABILIDADES.get(i).getNome_habilidade());
        }



    }

    /* Operações Vector */

    private static void AddPessoaEmVectorPessoa(String linha){

        String[] informacoes_linha = linha.split(";");

        Pessoa pessoa_adicionar = new Pessoa(informacoes_linha[0]);

        for(int i = 0; i < HABILIDADES.size(); i++){

            int nota = Integer.parseInt(informacoes_linha[i+1]);

            Habilidade habilidade_add = new Habilidade(HABILIDADES.get(i).getNome_habilidade(), nota);

            pessoa_adicionar.addHabilidade(habilidade_add);

        }

        PESSOAS.add(pessoa_adicionar);

    }

    private static void AddHabilidadeEmVectorHabilidade(String linha){

        Habilidade habilidade_adicionar = new Habilidade(linha);

        HABILIDADES.add(habilidade_adicionar);

    }

    /* Arquivos */

    private static File RetornaArquivo(String path){

        return new File(path);

    }

    private static void LeArquivoHabilidades(File arquivo, boolean is_habilidade){

        try(FileReader fileReader = new FileReader(arquivo)){

            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){

                String linha = bufferedReader.readLine();

                while(linha != null){

                    if(is_habilidade){
                        AddHabilidadeEmVectorHabilidade(linha);
                    }else{
                        AddPessoaEmVectorPessoa(linha);
                    }
                    
                    linha = bufferedReader.readLine();

                }

                bufferedReader.close();

            }catch(Exception e){
                System.err.println(e);
            }

            fileReader.close();


        }catch(Exception e){
            System.err.println(e);
        }

    }

    

    
}
