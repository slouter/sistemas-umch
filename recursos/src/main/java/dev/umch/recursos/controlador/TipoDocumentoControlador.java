package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.TipoDocumento;
import dev.umch.recursos.servicio.TipoDocumentoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipo-documento")
@RequiredArgsConstructor
public class TipoDocumentoControlador {

    private final TipoDocumentoServicio tipoDocumentoServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<TipoDocumento> obtenerTiposDocumento() {
        return this.tipoDocumentoServicio.listarTiposDocumentos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        this.tipoDocumentoServicio.agregarTipoDocumento(tipoDocumento);
    }

}
