package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.NivelEducativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelEducativoRepositorio extends JpaRepository<NivelEducativo, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de nivel educativo:
    // Optional<NivelEducativo> findByNombre(String nombre);
}
