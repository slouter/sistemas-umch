package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de tipo de documento:
    // Optional<TipoDocumento> findByNombre(String nombre);
}
