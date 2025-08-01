package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.EstadoCivil;
import dev.umch.recursos.repositorio.EstadoCivilRepositorio;
import dev.umch.recursos.repositorio.PersonaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstadoCivilServicio {

    private final EstadoCivilRepositorio estadoCivilRepositorio;

    //Listar todos los estados civiles
    public List<EstadoCivil> listarEstadosCiviles() {
        var estadosCiviles = estadoCivilRepositorio.findAll();
        return estadosCiviles.stream()
                .map(this::mapToEstadosCivilResponse)
                .collect(Collectors.toList());
    }

    //Agregar un nuevo estado civil
    public void agregarEstadoCivil(EstadoCivil estadoCivil){
        var estado = EstadoCivil.builder()
                .idEstadoCivil(estadoCivil.getIdEstadoCivil())
                .nombreEstadoCivil(estadoCivil.getNombreEstadoCivil())
                .build();

        estadoCivilRepositorio.save(estado);
        log.info("Estado Civil agregado: {}", estado);
    }

    public EstadoCivil mapToEstadosCivilResponse(EstadoCivil estadoCivil) {
        return EstadoCivil.builder()
                .idEstadoCivil(estadoCivil.getIdEstadoCivil())
                .nombreEstadoCivil(estadoCivil.getNombreEstadoCivil())
                .build();
    }

}
