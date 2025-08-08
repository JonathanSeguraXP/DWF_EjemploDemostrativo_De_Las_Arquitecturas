package com.ejemplo.crudclean.infrastructure;

import com.ejemplo.crudclean.application.TareaService;
import com.ejemplo.crudclean.domain.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.listarTareas();
    }

    @GetMapping("/{id}")
    public Tarea obtenerTarea(@PathVariable int id) {
        return tareaService.obtenerTarea(id);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable int id, @RequestBody Tarea tareaActualizada) {
        return tareaService.actualizarTarea(id, tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable int id) {
        return tareaService.eliminarTarea(id) ? "Tarea eliminada" : "No encontrada";
    }
}
