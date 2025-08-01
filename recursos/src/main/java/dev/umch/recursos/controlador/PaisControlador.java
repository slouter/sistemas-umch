package dev.umch.recursos.controlador;

import dev.umch.recursos.entidad.Pais;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import dev.umch.recursos.servicio.PaisServicio;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/pais", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PaisControlador {

    private final PaisServicio paisServicio;

    //Metodo con la anotacion @circuitbreaker
    @CircuitBreaker(name = "recursos", fallbackMethod = "fallbackObtenerPaises")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public List<Pais> obtenerPaises(){
        log.info("Lista de países obtenida exitosamente");
        return paisServicio.listarPaises();
    }

    // Método para obtener la lista de países
    //@GetMapping
    //@ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    //public List<Pais> obtenerPaises(){
    //    log.info("Lista de países obtenida exitosamente");
    //   return paisServicio.listarPaises();
    //}

    // Método para obtener un país por su ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public ResponseEntity<Pais> obtenerPaisPorId(@PathVariable Integer id) {
        Pais pais = paisServicio.obtenerPaisPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pais);
    }

    // Método para agregar un nuevo país
    @PostMapping("/agregar/")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<Void> agregarPais(@RequestBody Pais pais) {
        this.paisServicio.agregarPais(pais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Método para eliminar un país por su ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<Void> eliminarPais(@PathVariable Integer id) {
        this.paisServicio.eliminarPais(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Método para actualizar un país
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_Admin')")
    public ResponseEntity<Void> actualizarPais(@RequestBody Pais pais) {
        this.paisServicio.actualizarPais(pais);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // metodo para realizar una busqueda de paises por nombre
    @GetMapping("/buscar/{nombrePais}")
    @PreAuthorize("hasRole('ROLE_Admin') or hasRole('Role_User')")
    public ResponseEntity<List<Pais>> buscarPaisesPorNombre(@PathVariable String nombrePais) {
        List<Pais> paises = paisServicio.buscarPaisesPorNombre(nombrePais);
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }

    // PRUEBA RESILENCIA
    public List<Pais> fallbackObtenerPaises(Throwable t) {
        log.error("Error al obtener países. Circuit Breaker activado: {}", t.getMessage());
        return List.of(); // lista vacía como fallback
    }


}
