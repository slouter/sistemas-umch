package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.Ocupacion;
import dev.umch.recursos.servicio.OcupacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ocupacion")
@RequiredArgsConstructor
public class OcupacionControlador {

    private final OcupacionServicio ocupacionServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<Ocupacion> obtenerOcupaciones() {
        return this.ocupacionServicio.listarOcupaciones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarOcupacion(@RequestBody Ocupacion ocupacion) {
        this.ocupacionServicio.agregarOcupacion(ocupacion);
    }

}
