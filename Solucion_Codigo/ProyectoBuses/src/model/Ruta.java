package model;

import java.util.ArrayList;//arreglo dinamico
import java.util.List;

public class Ruta {
    private String nombre;
    private List<Parada> paradas;//list permite agregar, recorrer y manipular
                                 //dinamicamente la coleccion de
    
    //el constructor recibe una lista bacia de paradas

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
    
    //permite agregar paradas a la ruta

    public void agregarParada(Parada parada) {
        paradas.add(parada);
    }
}
