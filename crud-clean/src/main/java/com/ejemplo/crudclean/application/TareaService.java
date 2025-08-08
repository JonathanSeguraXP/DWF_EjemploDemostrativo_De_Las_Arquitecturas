package com.ejemplo.crudclean.application;

import com.ejemplo.crudclean.domain.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService {

    private List<Tarea> tareas = new ArrayList<>();
    private int idCounter = 1;

    public Tarea crearTarea(Tarea tarea) {
        tarea.setId(idCounter++);
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public Tarea obtenerTarea(int id) {
        return tareas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Tarea actualizarTarea(int id, Tarea tareaActualizada) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setTitulo(tareaActualizada.getTitulo());
                tarea.setDescripcion(tareaActualizada.getDescripcion());
                return tarea;
            }
        }
        return null;
    }

    public boolean eliminarTarea(int id) {
        return tareas.removeIf(t -> t.getId() == id);
    }
}
