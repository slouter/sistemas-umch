package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.Religion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReligionRepositorio extends JpaRepository<Religion, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de religión:
    // Optional<Religion> findByNombre(String nombre);
}
