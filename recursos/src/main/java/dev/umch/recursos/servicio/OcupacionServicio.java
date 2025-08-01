package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.Ocupacion;
import dev.umch.recursos.repositorio.OcupacionRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OcupacionServicio {

    private final OcupacionRepositorio ocupacionRepositorio;

    public List<Ocupacion> listarOcupaciones() {
        var ocupaciones = ocupacionRepositorio.findAll();
        return ocupaciones.stream()
                .map(this::mapToOcupacionResponse)
                .collect(Collectors.toList());
    }

    public void agregarOcupacion(Ocupacion ocupacion) {
        var nuevaOcupacion = Ocupacion.builder()
                .idOcupacion(ocupacion.getIdOcupacion())
                .nombreOcupacion(ocupacion.getNombreOcupacion())
                .build();

        ocupacionRepositorio.save(nuevaOcupacion);
        log.info("Ocupación agregada: {}", nuevaOcupacion);
    }

    public Ocupacion mapToOcupacionResponse(Ocupacion ocupacion) {
        return Ocupacion.builder()
                .idOcupacion(ocupacion.getIdOcupacion())
                .nombreOcupacion(ocupacion.getNombreOcupacion())
                .build();
    }
}
