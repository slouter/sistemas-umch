package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.TipoVia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoViaRepositorio extends JpaRepository<TipoVia, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de tipo de vía:
    // Optional<TipoVia> findByNombre(String nombre);
}
