package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.Pais;
import dev.umch.recursos.entidad.TipoZona;
import dev.umch.recursos.repositorio.TipoZonaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TipoZonaServicio {

    private final TipoZonaRepositorio tipoZonaRepositorio;

    public List<TipoZona> listarTiposZonas() {
        var tiposZonas = tipoZonaRepositorio.findAll();
        return tiposZonas.stream()
                .map(this::mapToTipoZonaResponse)
                .collect(Collectors.toList());
    }

    public void agregarTipoZona(TipoZona tipoZona) {
        var nuevoTipoZona = TipoZona.builder()
                .idTipoZona(tipoZona.getIdTipoZona())
                .nombreTipoZona(tipoZona.getNombreTipoZona())
                .build();

        tipoZonaRepositorio.save(nuevoTipoZona);
        log.info("Tipo de Zona agregado: {}", nuevoTipoZona);
    }

    public TipoZona mapToTipoZonaResponse(TipoZona tipoZona) {
        return TipoZona.builder()
                .idTipoZona(tipoZona.getIdTipoZona())
                .nombreTipoZona(tipoZona.getNombreTipoZona())
                .build();
    }

}
