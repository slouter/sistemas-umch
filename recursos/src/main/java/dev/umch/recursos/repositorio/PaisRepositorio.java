package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepositorio extends JpaRepository<Pais, Integer> {

    // Método para buscar países por nombre, ignorando mayúsculas y minúsculas
    List<Pais> findByNombrePaisContainingIgnoreCase(String nombre);

}
