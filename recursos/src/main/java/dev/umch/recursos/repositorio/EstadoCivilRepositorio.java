package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCivilRepositorio extends JpaRepository<EstadoCivil, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de estado civil:
    // List<EstadoCivil> findByNombreEstadoCivil(String nombreEstadoCivil);
}
