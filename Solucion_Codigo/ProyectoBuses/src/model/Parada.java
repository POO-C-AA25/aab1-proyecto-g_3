package model;

public class Parada {
    ///se hace privado para acceder solo por medio de metodos
    private String nombre;
    private String ubicacion;
    
    //Creamos el constructor para inicializar los datos

    public Parada(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    //Dado que ubicacion es un dato que puede cambiar solo usamos set para este
    //para evitar incosistencias en el sistema nombre no sera cambiado
    //debo arreglar ese tema luego

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

