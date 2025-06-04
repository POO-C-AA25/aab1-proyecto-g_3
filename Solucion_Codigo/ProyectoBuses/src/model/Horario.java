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
    
    //igual aqui, de cmabiar los horarios y paradas se pondran los set necesarios

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