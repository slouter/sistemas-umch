package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.EstadoCivil;
import dev.umch.recursos.entidad.Idioma;
import dev.umch.recursos.repositorio.EstadoCivilRepositorio;
import dev.umch.recursos.repositorio.IdiomaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdiomaServicio {

    private final IdiomaRepositorio idiomaRepositorio;

    public List<Idioma> listarIdiomas() {
        var idiomas = idiomaRepositorio.findAll();
        return idiomas.stream()
                .map(this::mapToIdiomaResponse)
                .toList();
    }

    public void agregarIdioma(Idioma idioma) {
        var nuevoIdioma = Idioma.builder()
                .idIdioma(idioma.getIdIdioma())
                .nombreIdioma(idioma.getNombreIdioma())
                .nombreCortoIdioma(idioma.getNombreCortoIdioma())
                .build();

        idiomaRepositorio.save(nuevoIdioma);
        log.info("Idioma agregado: {}", nuevoIdioma);
    }

    public Idioma mapToIdiomaResponse(Idioma idioma) {
        return Idioma.builder()
                .idIdioma(idioma.getIdIdioma())
                .nombreIdioma(idioma.getNombreIdioma())
                .nombreCortoIdioma(idioma.getNombreCortoIdioma())
                .build();
    }

}
