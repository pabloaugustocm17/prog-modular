public class Tempo {
    
    private int horas;
    private int minutos;
    private int segundos;

    private void init(int horas, int minutos, int segundos){

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;

    }

    public Tempo(){
        init(0, 0, 0);
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    


}
