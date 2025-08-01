package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.TipoZona;
import dev.umch.recursos.servicio.TipoZonaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipo-zona")
@RequiredArgsConstructor
public class TipoZonaControlador {

    private final TipoZonaServicio tipoZonaServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<TipoZona> obtenerTiposZona() {
        return this.tipoZonaServicio.listarTiposZonas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarTipoZona(@RequestBody TipoZona tipoZona) {
        this.tipoZonaServicio.agregarTipoZona(tipoZona);
    }

}