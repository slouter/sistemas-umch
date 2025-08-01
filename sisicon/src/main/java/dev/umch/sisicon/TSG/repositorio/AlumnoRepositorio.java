package dev.umch.sisicon.TSG.repositorio;

import dev.umch.sisicon.TSG.entidad.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {

    //Buscar alumno por codigo
    List<Alumno> findByCodigoAlumno(String codigoAlumno);
}
