package dev.umch.sisicon.TSG.servicio;

import dev.umch.sisicon.TSG.entidad.Alumno;
import dev.umch.sisicon.TSG.repositorio.AlumnoRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlumnoServicio {

    private final AlumnoRepositorio alumnoRepositorio;

    // Aquí puedes agregar métodos para manejar la lógica de negocio relacionada con los alumnos
    public List<Alumno> listarAlumnos() {
        var alumnos = alumnoRepositorio.findAll();
        log.info("Listando todos los alumnos: " + alumnos.size() + " registros encontrados.");
        return alumnos.stream()
                .map(this::mapToAlumnoResponse)
                .collect(Collectors.toList());
    }

    public List<Alumno> buscarAlumnoPorCodigo(String idAlumno){
        if (idAlumno == null || idAlumno.isEmpty()) {
            throw new IllegalArgumentException("El codigo de alumno no puede ser nulo o vacío");
        }
        return alumnoRepositorio.findByCodigoAlumno(idAlumno);
    }

    public Alumno mapToAlumnoResponse(Alumno alumno) {
        return Alumno.builder()
                .idAlumno(alumno.getIdAlumno())
                //.idPersona(alumno.getIdPersona())
                .persona(alumno.getPersona())
                .codigoAlumno(alumno.getCodigoAlumno())
                .flagGeneraUsuario(alumno.getFlagGeneraUsuario())
                .flagIdioma(alumno.getFlagIdioma())
                .idUsuarioModifica(alumno.getIdUsuarioModifica())
                .fechaModifica(alumno.getFechaModifica())
                .situacionRegistro(alumno.getSituacionRegistro())
                .build();
    }
}
