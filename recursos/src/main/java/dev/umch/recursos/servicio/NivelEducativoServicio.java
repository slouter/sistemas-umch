package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.NivelEducativo;
import dev.umch.recursos.repositorio.NivelEducativoRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NivelEducativoServicio {

    private final NivelEducativoRepositorio nivelEducativoRepositorio;

    public List<NivelEducativo> listarNivelesEducativos() {
        var nivelesEducativos = nivelEducativoRepositorio.findAll();
        return nivelesEducativos.stream()
                .map(this::mapToNivelEducativoResponse)
                .collect(Collectors.toList());
    }

    public void agregarNivelEducativo(NivelEducativo nivelEducativo) {
        var nuevoNivel = NivelEducativo.builder()
                .idNivelEducativo(nivelEducativo.getIdNivelEducativo())
                .nombreNivelEducativo(nivelEducativo.getNombreNivelEducativo())
                .build();

        nivelEducativoRepositorio.save(nuevoNivel);
        log.info("Nivel Educativo agregado: {}", nuevoNivel);
    }

    public NivelEducativo mapToNivelEducativoResponse(NivelEducativo nivelEducativo) {
        return NivelEducativo.builder()
                .idNivelEducativo(nivelEducativo.getIdNivelEducativo())
                .nombreNivelEducativo(nivelEducativo.getNombreNivelEducativo())
                .build();
    }

}
