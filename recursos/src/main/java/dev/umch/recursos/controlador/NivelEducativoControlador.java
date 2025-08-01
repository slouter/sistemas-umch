package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.NivelEducativo;
import dev.umch.recursos.servicio.NivelEducativoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/nivel-educativo")
@RequiredArgsConstructor
public class NivelEducativoControlador {

    private final NivelEducativoServicio nivelEducativoServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<NivelEducativo> obtenerTodos() {
        return this.nivelEducativoServicio.listarNivelesEducativos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarNivelEducativo(@RequestBody NivelEducativo nivelEducativo) {
        this.nivelEducativoServicio.agregarNivelEducativo(nivelEducativo);
    }
}
