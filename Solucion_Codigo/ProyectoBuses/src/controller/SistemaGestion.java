package controller;

import model.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SistemaGestion {

    private List<Ruta> rutas = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    // Aqui de ejemplo añadi algunas paradas y en la ruta que iran con su respectivo horarios
    public void cargarDatosIniciales() {
        Ruta ruta1 = new Ruta("Linea 1");
        ruta1.agregarParada(new Parada("Parada Norte", "Av. Universitaria"));
        ruta1.agregarParada(new Parada("Parada Centro", "Plaza Central"));
        rutas.add(ruta1);

        Ruta ruta2 = new Ruta("Linea 2");
        ruta2.agregarParada(new Parada("Parada Este", "Av. Loja y 10 de Agosto"));
        ruta2.agregarParada(new Parada("Parada Sur", "Av. Loja y 25 de Junio"));
        rutas.add(ruta2);

        Ruta ruta3 = new Ruta("Linea 3");
        ruta3.agregarParada(new Parada("Parada Oeste", "Av. Amazonas y Bolívar"));
        ruta3.agregarParada(new Parada("Parada Centro", "Plaza Principal"));
        rutas.add(ruta3);

        horarios.add(new Horario("Parada Norte", "07:00", "07:05"));
        horarios.add(new Horario("Parada Centro", "07:10", "07:15"));
        horarios.add(new Horario("Parada Este", "08:00", "08:05"));
        horarios.add(new Horario("Parada Sur", "08:10", "08:15"));
        horarios.add(new Horario("Parada Oeste", "09:00", "09:05"));
        horarios.add(new Horario("Parada Central", "09:10", "09:15"));
    }

    public void mostrarRutas() {
        for (Ruta ruta : rutas) {
            System.out.println("- " + ruta.getNombre());
        }
    }

    public void mostrarRutaDetalle(String nombreRuta) {
        for (Ruta ruta : rutas) {
            if (ruta.getNombre().equalsIgnoreCase(nombreRuta)) {
                System.out.println("Ruta: " + ruta.getNombre());
                for (Parada parada : ruta.getParadas()) {
                    System.out.println("  Parada: " + parada.getNombre() + " - " + parada.getUbicacion());
                    for (Horario horario : horarios) {
                        if (horario.getParada().equals(parada.getNombre())) {
                            System.out.println("    Horario: " + horario.getHoraInicio() + " - " + horario.getHoraFin());
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Ruta no encontrada.");
    }

    // Elimina una ruta por nombre
    public boolean eliminarRuta(String nombreRuta) {
        Iterator<Ruta> iterator = rutas.iterator();// esto nos permite recorrer
        //una coleccion como una lista en este caso de forma segura y controlada
        while (iterator.hasNext()) {//mientras se encuentre un elemento más obtenemos la siguiente ruta
            Ruta ruta = iterator.next();
            //aqui compramos cadenas ignorando mayusculas y
            if (ruta.getNombre().equalsIgnoreCase(nombreRuta)) {
                //eliminamos la ruta con el iterator y retornamos que se elimino de forma correcta
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void agregarRuta(String nombreRuta, List<Parada> paradas, List<Horario> horariosRuta) {
        Ruta nuevaRuta = new Ruta(nombreRuta);
        for (Parada parada : paradas) {
            nuevaRuta.agregarParada(parada);
        }
        rutas.add(nuevaRuta);
        horarios.addAll(horariosRuta); // Añade los horarios asociados a esta ruta
    }

    public boolean optimizarRutaPorRedundancia(String nombreRuta) {
        Ruta rutaSeleccionada = null;

        // Buscar la ruta con el nombre dado
        for (Ruta ruta : rutas) {
            if (ruta.getNombre().equalsIgnoreCase(nombreRuta)) {
                rutaSeleccionada = ruta;
                break;
            }
        }

        if (rutaSeleccionada == null) {
            System.out.println("Ruta no encontrada.");
            return false;
        }

        List<Parada> paradasParaEliminar = new ArrayList<>();

        // Buscar paradas duplicadas con otras rutas
        for (Parada parada : rutaSeleccionada.getParadas()) {
            for (Ruta otraRuta : rutas) {
                if (!otraRuta.getNombre().equalsIgnoreCase(nombreRuta)) {
                    for (Parada pOtra : otraRuta.getParadas()) {
                        if (pOtra.getNombre().equalsIgnoreCase(parada.getNombre())) {
                            paradasParaEliminar.add(parada);
                            break;
                        }
                    }
                }
            }
        }

        if (paradasParaEliminar.isEmpty()) {
            System.out.println("Ruta no puede optimizarse (no hay paradas duplicadas).");
            return false;
        }

        // Eliminar paradas duplicadas
        rutaSeleccionada.getParadas().removeAll(paradasParaEliminar);

        // También eliminamos los horarios relacionados con las paradas eliminadas
        horarios.removeIf(h -> paradasParaEliminar.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(h.getParada())));

        System.out.println("Ruta optimizada eliminando paradas duplicadas con otras rutas.");
        return true;
    }

    public void mostrarDetallesDeTodasLasRutas() {
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas registradas.");
            return;
        }

        for (Ruta ruta : rutas) {
            System.out.println("Ruta: " + ruta.getNombre());
            for (Parada parada : ruta.getParadas()) {
                System.out.println("  Parada: " + parada.getNombre() + " - " + parada.getUbicacion());
                for (Horario horario : horarios) {
                    if (horario.getParada().equalsIgnoreCase(parada.getNombre())) {
                        System.out.println("    Horario: " + horario.getHoraInicio() + " - " + horario.getHoraFin());
                    }
                }
            }
            System.out.println("----------------------------------------");
        }
    }

}
