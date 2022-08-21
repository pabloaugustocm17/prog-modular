public class MetodosUtil {

    static final String SEGUNDOS = "Segundos";
    static final String MINUTOS = "Minutos";

    MetodosUtil(){
        
    }

    /**
     * @param mensagem -> mostra uma mensagem no console
     */
    public static void ImprimiMensagem(String mensagem){
        
        System.out.println(mensagem);

    }

    /**
     * @param erro -> mostra uma mensagem de erro no console
     */
    public static void ImprimiMensagemErro(String erro){

        System.err.println(erro);

    }


}
