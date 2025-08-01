package dev.umch.recursos.repositorio;

import dev.umch.recursos.entidad.UsuarioSistema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSistemaRepositorio extends JpaRepository<UsuarioSistema, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario

    //obtener registro por login
    UsuarioSistema findByLoginUsuarioSistema(String loginUsuarioSistema);

}
