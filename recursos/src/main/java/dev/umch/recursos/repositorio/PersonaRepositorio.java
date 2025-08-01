package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre:
    List<Persona> findByNombre(String nombre);

    List<Persona> findByNumeroDocumento(String numeroDocumento);

}
