package dev.umch.recursos.controlador;


import dev.umch.recursos.entidad.Pais;
import dev.umch.recursos.entidad.Persona;
import dev.umch.recursos.servicio.PersonaServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/persona", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PersonaControlador {

    private final PersonaServicio personaServicio;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public ResponseEntity<List<Persona>> obtenerPersonas(){
        List<Persona> personas = personaServicio.listarPersonas();
        if (personas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/nombre/{nombre}")
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public ResponseEntity<List<Persona>> obtenerPersonasPorNombre(@PathVariable String nombre) {
        List<Persona> personas = personaServicio.buscarPorNombre(nombre);
        if (personas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/documento/{numeroDocumento}")
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public ResponseEntity<List<Persona>> obtenerPersonasPorDocumento(@PathVariable String numeroDocumento) {
        List<Persona> personas = personaServicio.buscarPorDocumento(numeroDocumento);
        if (personas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personas);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<Void> agregarPersona(@RequestBody Persona persona) {
        personaServicio.addPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created sin body
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')") // Añadido si se requiere seguridad
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        persona.setIdPersona(id);
        Persona personaActualizada = personaServicio.actualizarPersona(persona);
        return ResponseEntity.ok(personaActualizada); // 200 OK con el objeto actualizado
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')") // Añadido si se requiere seguridad
    public ResponseEntity<Void> eliminarPersona(@PathVariable Integer id) {
        personaServicio.eliminarPersona(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}