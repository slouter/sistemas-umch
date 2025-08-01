package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.Pais;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import dev.umch.recursos.repositorio.PaisRepositorio;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaisServicio {

    private final PaisRepositorio paisRepositorio;

    public List<Pais> listarPaises() {
        var paises = paisRepositorio.findAll();
        return paises.stream()
                .map(this::mapToPaisResponse)
                .collect(Collectors.toList());
    }

    public void agregarPais(Pais pais) {
        var paisExistente = Pais.builder()
                .idPais(pais.getIdPais())
                .nombrePais(pais.getNombrePais())
                .build();

        paisRepositorio.save(paisExistente);
        log.info("País agregado: {}", paisExistente);
    }

    public void eliminarPais(Integer id) {
        var pais = paisRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + id));
        paisRepositorio.delete(pais);
        log.info("País eliminado: {}", pais);
    }

    public void actualizarPais(Pais pais) {
        var paisExistente = paisRepositorio.findById(pais.getIdPais())
                .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + pais.getIdPais()));

        paisExistente.setNombrePais(pais.getNombrePais());
        paisRepositorio.save(paisExistente);
        log.info("País actualizado: {}", paisExistente);
    }

    public Pais obtenerPaisPorId(Integer id) {
        return paisRepositorio.findById(id)
                .map(this::mapToPaisResponse)
                .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + id));
    }

    public List<Pais> buscarPaisesPorNombre(String nombre) {
        return paisRepositorio.findByNombrePaisContainingIgnoreCase(nombre).stream()
                .map(this::mapToPaisResponse)
                .collect(Collectors.toList());
    }

    public Pais mapToPaisResponse(Pais pais) {
        return pais.builder()
                .idPais(pais.getIdPais())
                .nombrePais(pais.getNombrePais())
                .build();
    }

}
