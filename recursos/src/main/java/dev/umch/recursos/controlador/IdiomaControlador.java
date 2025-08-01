package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.Idioma;
import dev.umch.recursos.servicio.IdiomaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/idioma")
@RequiredArgsConstructor
public class IdiomaControlador {

    private final IdiomaServicio idiomaServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<Idioma> obtenerIdiomas() {
        return this.idiomaServicio.listarIdiomas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarIdioma(@RequestBody Idioma idioma) {
        this.idiomaServicio.agregarIdioma(idioma);
    }

}
