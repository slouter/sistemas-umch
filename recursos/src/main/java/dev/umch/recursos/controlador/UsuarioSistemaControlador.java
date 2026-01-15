package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.UsuarioSistema;
import dev.umch.recursos.servicio.UsuarioSistemaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping (value = "/api/usuarios-sistema", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UsuarioSistemaControlador {

    private final UsuarioSistemaServicio usuarioSistemaServicio;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('ROLE_User')")
    public List<UsuarioSistema> listarUsuarios() {
        return usuarioSistemaServicio.listarUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarUsuario(@RequestBody UsuarioSistema usuarioSistema) {
        usuarioSistemaServicio.agregarUsuario(usuarioSistema);
    }
}
