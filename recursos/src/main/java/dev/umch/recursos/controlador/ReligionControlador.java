package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.Religion;
import dev.umch.recursos.servicio.ReligionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/religion")
@RequiredArgsConstructor
public class ReligionControlador {

    private final ReligionServicio religionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<Religion> obtenerReligiones() {
        return this.religionService.listarReligiones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public void agregarReligion(@RequestBody Religion religion) {
        this.religionService.agregarReligion(religion);
    }

}
