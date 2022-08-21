class Tempo {

    private int horas;
    private int minutos;
    private int segundos;

    /* Construtor */

    private void init(int horas, int minutos, int segundos) {

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;

    }

    public Tempo() {
        init(0, 0, 0);
    }

    /* Métodos Públicos */

    /**
     * @param tempo_adicionar  -> simboliza o tempo a ser adicionado no contador
     * @param valor_atualizado -> uma string que mostra se o valor deve ser acionado
     *                         em segundos ou minutos
     */
    public void AdicionaTempo(int tempo_adicionar, String valor_atualizado) {

       if(valor_atualizado.equals(MetodosUtil.SEGUNDOS)){
            AtualizarTempo(tempo_adicionar, true);
       }else if(valor_atualizado.equals(MetodosUtil.MINUTOS)){
            AtualizarTempo(tempo_adicionar, false);
       }

    }

    public void ImprimiTempo() {

        if (this.horas < 10) {
            MetodosUtil.ImprimiMensagem("0" + this.horas + ":");
        } else {
            MetodosUtil.ImprimiMensagem(this.horas + ":");
        }

        if (this.minutos < 10) {
            MetodosUtil.ImprimiMensagem("0" + this.minutos + ":");
        } else {
            MetodosUtil.ImprimiMensagem(this.minutos + ":");
        }

        if (this.segundos < 10) {
            MetodosUtil.ImprimiMensagem("0" + this.segundos);
        } else {
            MetodosUtil.ImprimiMensagem(this.segundos + "");
        }

    }

    public boolean PausaTempo() {

        return !((this.segundos == 0) && (this.minutos == 0) && (this.horas == 0));

    }

    public void ZerarTempo() {

        this.ZerarTempoMO();

    }

    /* Métodos Privados */

    /**
     * @param valor       -> recebe o valor a ser verificado
     * @param is_segundos -> é validado se o 'valor' é segundo ou minuto
     * @return boolean -> caso seja true o número é válido 
     */
    private boolean Verificacao60(int valor, boolean is_segundos) {

        if (valor >= 60 || valor < 0) {

            System.out.print("Valor para ");

            if (is_segundos) {
                System.out.print("segundos ");
            } else {
                System.out.print("minutos ");
            }

            System.out.println("informados estão errados");

            return false;

        } else {

            return true;

        }

    }


    
    /**
     * @param horas -> recebe o valor das horas a ser atualizada
     */
    private void AtualizarHoras(int horas) {

        if (horas >= 1) {
            System.err.println("O micro ondas ou sua paciência irá explodir");
        }

        this.horas += horas;

    }


    /**
     * @param tempo_atualizar -> recebe o tempo a ser adicionado ao cronometro
     * @param is_segundos -> recebe a informação se o valor a ser adicionado é segundos ou minutos
     */
    private void AtualizarTempo(int tempo_atualizar, boolean is_segundos) {

        if (Verificacao60(tempo_atualizar, is_segundos)) {

            int tempo_menor_adicionar = 0;
            int tempo_maior_adicionar = 0;

            int tempo_menor_atual = 0;
            int tempo_maior_atual = 0;

            if (is_segundos) {
                tempo_menor_atual = this.segundos;
                tempo_maior_atual = this.minutos;
            } else {
                tempo_menor_atual = this.minutos;
                tempo_maior_atual = this.horas;
            }

            int soma_tempo_menor = tempo_menor_atual + tempo_atualizar;

            if (soma_tempo_menor >= 60) {

                tempo_maior_adicionar = soma_tempo_menor / 60;
                tempo_menor_adicionar = soma_tempo_menor % 60;
                tempo_maior_adicionar += tempo_maior_atual;

            } else {

                tempo_menor_adicionar = soma_tempo_menor;
                tempo_maior_adicionar = tempo_maior_atual;

            }

            if (is_segundos) {
                this.segundos = tempo_menor_adicionar;
                this.minutos = tempo_maior_adicionar;
            } else {
                this.minutos = tempo_menor_adicionar;
                AtualizarHoras(tempo_maior_adicionar);
            }

        }

    }

    private void ZerarTempoMO() {

        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;

    }
}
