class Tempo {

    private int horas;
    private int minutos;
    private int segundos;

    private void init(int horas, int minutos, int segundos) {

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;

    }

    public Tempo() {
        init(0, 0, 0);
    }

    public void AdicionaTempo(int tempo_adicionar, String valor_atualizado) {

        switch (valor_atualizado) {

            case "Segundos":
                AtualizarTempo(tempo_adicionar, true);
                break;

            case "Minutos":
                AtualizarTempo(tempo_adicionar, false);
                break;

        }

    }

    public void ImprimiTempo(){

        if(this.horas < 10){
            System.out.print("0" + this.horas + ":");
        }else{
            System.out.print(this.horas + ":");
        }

        if(this.minutos < 10){
            System.out.print("0" + this.minutos + ":");
        }else{
            System.out.print(this.minutos + ":");
        }

        if(this.segundos < 10){
            System.out.println("0" + this.segundos);
        }else{
            System.out.println(this.segundos);
        }


    }

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

    private void AtualizarHoras(int horas) {

        if (horas >= 1) {
            System.err.println("O micro ondas ou sua paciência irá explodir");
        }

        this.horas += horas;

    }

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

    public boolean PausaTempo(){

        if(this.segundos == 0 && this.minutos == 0 && this.horas == 0){
            return false;
        }else{
            return true;
        }

    }
}
