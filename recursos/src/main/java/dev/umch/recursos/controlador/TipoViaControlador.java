package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.TipoVia;
import dev.umch.recursos.servicio.TipoViaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipo-via")
@RequiredArgsConstructor
public class TipoViaControlador {

    private final TipoViaServicio tipoViaServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<TipoVia> obtenerTiposVia() {
        return this.tipoViaServicio.listarTiposVia();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarTipoVia(TipoVia tipoVia) {
        this.tipoViaServicio.agregarTipoVia(tipoVia);
    }

}
