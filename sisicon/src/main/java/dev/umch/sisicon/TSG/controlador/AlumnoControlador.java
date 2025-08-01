package dev.umch.sisicon.TSG.controlador;

import dev.umch.recursos.entidad.Persona;
import dev.umch.recursos.servicio.PersonaServicio;
import dev.umch.sisicon.TSG.entidad.Alumno;
import dev.umch.sisicon.TSG.servicio.AlumnoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/stg/alumno", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AlumnoControlador {

    private final AlumnoServicio alumnoServicio;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public ResponseEntity<List<Alumno>> obtenerAlumnos() {
        List<Alumno> alumnos = alumnoServicio.listarAlumnos();
        if (alumnos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content si la lista está vacía
        }
        return ResponseEntity.ok(alumnos); // 200 OK con el cuerpo
    }

    @GetMapping("/nombre/{nombre}")
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public ResponseEntity<List<Alumno>> obtenerAlumnosPorCodigo(@PathVariable String nombre) {
        List<Alumno> alumnos = alumnoServicio.buscarAlumnoPorCodigo(nombre);
        if (alumnos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumnos);
    }

}