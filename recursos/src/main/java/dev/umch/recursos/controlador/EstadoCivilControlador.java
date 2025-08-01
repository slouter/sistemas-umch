package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.EstadoCivil;
import dev.umch.recursos.servicio.EstadoCivilServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/estado-civil", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EstadoCivilControlador {

    //primero instanciamos el servicio de estado civil
    private final EstadoCivilServicio estadoCivilServicio;

    //método para obtener los estados civiles
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<EstadoCivil> obtenerEstadosCiviles() {
        return this.estadoCivilServicio.listarEstadosCiviles();
    }

    //método para agregar un nuevo estado civil
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<Void> agregarEstadoCivil(@RequestBody EstadoCivil estadoCivil) {
        this.estadoCivilServicio.agregarEstadoCivil(estadoCivil);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
