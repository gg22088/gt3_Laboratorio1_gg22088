package org.laboratorio1.controller;

import org.laboratorio1.service.GestorTareas;
import org.laboratorio1.model.Tarea;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE TAREAS ===");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Ver tareas pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(descripcion);
                    System.out.println("✅ Tarea agregada correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la tarea a completar: ");
                    int id = scanner.nextInt();
                    gestor.marcarTareaComoCompletada(id);
                    System.out.println("✅ Si el ID existe, la tarea fue marcada como completada.");
                    break;

                case 3:
                    ArrayList<Tarea> pendientes = gestor.obtenerTareasPendientes();
                    if (pendientes.isEmpty()) {
                        System.out.println("No hay tareas pendientes. 🎉");
                    } else {
                        System.out.println("\nTareas pendientes:");
                        for (Tarea t : pendientes) {
                            System.out.println("ID " + t.getId() + " - " + t.getDescripcion());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("❌ Opción no válida, intente nuevamente.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
