package view;

import controller.SistemaGestion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

public class Interfaz {

    private SistemaGestion controlador;
    private Scanner scanner;

    public Interfaz() {
        controlador = new SistemaGestion();
        controlador.cargarDatosIniciales();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú de Gestión de Buses ---");
            System.out.println("1. Mostrar rutas");
            System.out.println("2. Mostrar detalle de ruta");
            System.out.println("3. Eliminar una ruta");
            System.out.println("4. Añadir una nueva ruta");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: \n");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ingresar numero valido");
                continue;
            }

            switch (opcion) {
                case 1:
                    controlador.mostrarRutas();
                    break;
                case 2:
                    System.out.print("Ingrese nombre:");
                    String nombreRuta = scanner.nextLine();
                    controlador.mostrarRutaDetalle(nombreRuta);
                    break;
                case 3:
                    System.out.print("Ingrese nombre:");
                    String rutaEliminar = scanner.nextLine();
                    boolean eliminado = controlador.eliminarRuta(rutaEliminar);
                    if (eliminado) {
                        System.out.println("ELIMINADO EXITOSAMENTE");
                    } else {
                        System.out.println("NO ENCONTRADA");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese nombre de la ruta: ");
                    String nuevaRuta = scanner.nextLine();

                    List<Parada> nuevasParadas = new ArrayList<>();
                    List<Horario> nuevosHorarios = new ArrayList<>();
                    String respuesta;
                    do {
                        System.out.print("Ingrese nombre de la parada: ");
                        String nombreParada = scanner.nextLine();

                        System.out.print("Ingrese ubicación de la parada: ");
                        String ubicacionParada = scanner.nextLine();

                        System.out.print("Ingrese hora de inicio en la parada: ");
                        String horaInicio = scanner.nextLine();

                        System.out.print("Ingrese hora de fin en la parada: ");
                        String horaFin = scanner.nextLine();

                        nuevasParadas.add(new Parada(nombreParada, ubicacionParada));
                        nuevosHorarios.add(new Horario(nombreParada, horaInicio, horaFin));

                        System.out.print("¿Desea añadir otra parada? (s/n): ");
                        respuesta = scanner.nextLine();
                    } while (respuesta.equalsIgnoreCase("s"));

                    controlador.agregarRuta(nuevaRuta, nuevasParadas, nuevosHorarios);
                    System.out.println("Ruta y horarios añadidos exitosamente.");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
