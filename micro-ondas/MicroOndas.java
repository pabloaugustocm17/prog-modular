public class MicroOndas {
    
    private Tempo cronometro;
    private boolean is_fechado;
    
    private void init(){
        this.cronometro = new Tempo();
        this.is_fechado = true;
    }

    public MicroOndas(){
        init();
    }

    public void AdicionaTempo(int tempo_adicionar, String valor_atualizado){

        switch (valor_atualizado) {

            case "Segundos":
                this.cronometro.AdicionaTempo(tempo_adicionar, "Segundos");
                break;

            case "Minutos":
                this.cronometro.AdicionaTempo(tempo_adicionar, "Minutos");
                break;

        }


    }

    public void MostraCronometro(){

        this.cronometro.ImprimiTempo();

    }

    public boolean IsFechado() {
        return is_fechado;
    }

    public void setIsFechado(boolean is_fechado) {
        this.is_fechado = is_fechado;
    }
    
}

