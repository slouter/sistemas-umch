package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.Religion;
import dev.umch.recursos.repositorio.ReligionRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReligionServicio {

    private final ReligionRepositorio religionRepositorio;

    public List<Religion> listarReligiones() {
        var religiones = religionRepositorio.findAll();
        return religiones.stream()
                .map(this::mapToReligionResponse)
                .collect(Collectors.toList());
    }

    public void agregarReligion(Religion religion) {
        var nuevaReligion = Religion.builder()
                .idReligion(religion.getIdReligion())
                .nombreReligion(religion.getNombreReligion())
                .build();

        religionRepositorio.save(nuevaReligion);
        log.info("Religión agregada: {}", nuevaReligion);
    }

    public Religion mapToReligionResponse(Religion religion) {
        return Religion.builder()
                .idReligion(religion.getIdReligion())
                .nombreReligion(religion.getNombreReligion())
                .build();
    }
}
