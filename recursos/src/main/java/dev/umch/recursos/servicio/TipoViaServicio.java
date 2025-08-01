package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.TipoVia;
import dev.umch.recursos.repositorio.TipoViaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TipoViaServicio {

    private final TipoViaRepositorio tipoViaRepositorio;

    public List<TipoVia> listarTiposVia() {
        var tiposvias = tipoViaRepositorio.findAll();
        return tiposvias.stream()
                .map(this::mapToTipoViaResponse)
                .collect(Collectors.toList());
    }

    public void agregarTipoVia(TipoVia tipoVia) {
        var nuevoTipoVia = TipoVia.builder()
                .idTipoVia(tipoVia.getIdTipoVia())
                .nombreTipoVia(tipoVia.getNombreTipoVia())
                .build();

        tipoViaRepositorio.save(nuevoTipoVia);
        log.info("Tipo de Vía agregado: {}", nuevoTipoVia);
    }

    public TipoVia mapToTipoViaResponse(TipoVia tipoVia) {
        return TipoVia.builder()
                .idTipoVia(tipoVia.getIdTipoVia())
                .nombreTipoVia(tipoVia.getNombreTipoVia())
                .build();
    }

}
