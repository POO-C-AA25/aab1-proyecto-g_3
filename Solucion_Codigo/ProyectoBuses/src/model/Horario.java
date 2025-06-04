package model;

public class Horario {

    private String parada;
    private String horaInicio;
    private String horaFin;

    public Horario(String parada, String horaInicio, String horaFin) {
        this.parada = parada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getParada() {
        return parada;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
}
