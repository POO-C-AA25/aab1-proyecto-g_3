package model;

import java.util.ArrayList;
import java.util.List;

public class Ruta {

    private String nombre;
    private List<Parada> paradas;

    public Ruta(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void agregarParada(Parada parada) {
        paradas.add(parada);
    }
}
