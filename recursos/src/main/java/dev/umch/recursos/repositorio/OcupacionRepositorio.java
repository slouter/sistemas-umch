package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.Ocupacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcupacionRepositorio extends JpaRepository<Ocupacion, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar por nombre de ocupación:
    // Optional<Ocupacion> findByNombre(String nombre);
}
