package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.TipoDocumento;
import dev.umch.recursos.repositorio.TipoDocumentoRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TipoDocumentoServicio {

    private final TipoDocumentoRepositorio tipoDocumentoRepositorio;

    public List<TipoDocumento> listarTiposDocumentos() {
        var tiposDocumentos = tipoDocumentoRepositorio.findAll();
        return tiposDocumentos.stream()
                .map(this::mapToTipoDocumentoResponse)
                .collect(Collectors.toList());
    }

    public void agregarTipoDocumento(TipoDocumento tipoDocumento) {
        var nuevoTipoDocumento = TipoDocumento.builder()
                .idTipoDocumento(tipoDocumento.getIdTipoDocumento())
                .nombreTipoDocumento(tipoDocumento.getNombreTipoDocumento())
                .build();

        tipoDocumentoRepositorio.save(nuevoTipoDocumento);
        log.info("Tipo de Documento agregado: {}", nuevoTipoDocumento);
    }

    public TipoDocumento mapToTipoDocumentoResponse(TipoDocumento tipoDocumento) {
        return TipoDocumento.builder()
                .idTipoDocumento(tipoDocumento.getIdTipoDocumento())
                .nombreTipoDocumento(tipoDocumento.getNombreTipoDocumento())
                .build();
    }
}
