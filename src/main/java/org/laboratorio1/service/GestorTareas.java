package org.laboratorio1.service;

import org.laboratorio1.model.Tarea;
import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;
    private int proximoId = 1;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(String descripcion) {
        Tarea nueva = new Tarea(proximoId, descripcion);
        tareas.add(nueva);
        proximoId++;
    }

    public void marcarTareaComoCompletada(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.setCompletada(true);
                break;
            }
        }
    }

    public ArrayList<Tarea> obtenerTareasPendientes() {
        ArrayList<Tarea> pendientes = new ArrayList<>();
        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }
}
