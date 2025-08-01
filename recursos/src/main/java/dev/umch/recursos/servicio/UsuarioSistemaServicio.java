package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.UsuarioSistema;
import dev.umch.recursos.repositorio.UsuarioSistemaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioSistemaServicio {

    private final UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    public List<UsuarioSistema> listarUsuarios() {
        var usuarios = usuarioSistemaRepositorio.findAll();
        return usuarios.stream()
                .map(this::mapToUsuarioSistemaResponse)
                .collect(Collectors.toList());
    }

    public void agregarUsuario(UsuarioSistema usuarioSistema) {
        var nuevoUsuario = UsuarioSistema.builder()
                .idUsuarioSistema(usuarioSistema.getIdUsuarioSistema())
                .loginUsuarioSistema(usuarioSistema.getLoginUsuarioSistema())
                .passwordUsuarioSistema(usuarioSistema.getPasswordUsuarioSistema())
                .numeroAleatorio(usuarioSistema.getNumeroAleatorio())
                .flagRestriccionHorario(usuarioSistema.getFlagRestriccionHorario())
                .horarioInicioRestriccion(usuarioSistema.getHorarioInicioRestriccion())
                .horarioFinalRestriccion(usuarioSistema.getHorarioFinalRestriccion())
                .horaInicioAcceso(usuarioSistema.getHoraInicioAcceso())
                .horaFinAcceso(usuarioSistema.getHoraFinAcceso())
                .flagIdioma(usuarioSistema.getFlagIdioma())
                .flagEnviaCorreo(usuarioSistema.getFlagEnviaCorreo())
                .claveTemporal(usuarioSistema.getClaveTemporal())
                .flagActivaCuenta(usuarioSistema.getFlagActivaCuenta())
                .fechaActivacion(usuarioSistema.getFechaActivacion())
                .keyActivacion(usuarioSistema.getKeyActivacion())
                .situacionCuenta(usuarioSistema.getSituacionCuenta())
                .keyAcceso(usuarioSistema.getKeyAcceso())
                .flagCuentaVerificada(usuarioSistema.getFlagCuentaVerificada())
                .flagAceptaPoliticaProteccion(usuarioSistema.getFlagAceptaPoliticaProteccion())
                .flagAceptaNovedades(usuarioSistema.getFlagAceptaNovedades())
                .idUsuarioRegistra(usuarioSistema.getIdUsuarioRegistra())
                .fechaRegistra(usuarioSistema.getFechaRegistra())
                .idUsuarioModifica(usuarioSistema.getIdUsuarioModifica())
                .fechaModifica(usuarioSistema.getFechaModifica())
                .situacionRegistro(usuarioSistema.getSituacionRegistro())
                .build();

        usuarioSistemaRepositorio.save(nuevoUsuario);
        log.info("Usuario agregado: {}", nuevoUsuario);
    }

    public UsuarioSistema mapToUsuarioSistemaResponse(UsuarioSistema usuarioSistema) {
        return UsuarioSistema.builder()
                .idUsuarioSistema(usuarioSistema.getIdUsuarioSistema())
                .loginUsuarioSistema(usuarioSistema.getLoginUsuarioSistema())
                .passwordUsuarioSistema(usuarioSistema.getPasswordUsuarioSistema())
                .numeroAleatorio(usuarioSistema.getNumeroAleatorio())
                .flagRestriccionHorario(usuarioSistema.getFlagRestriccionHorario())
                .horarioInicioRestriccion(usuarioSistema.getHorarioInicioRestriccion())
                .horarioFinalRestriccion(usuarioSistema.getHorarioFinalRestriccion())
                .horaInicioAcceso(usuarioSistema.getHoraInicioAcceso())
                .horaFinAcceso(usuarioSistema.getHoraFinAcceso())
                .flagIdioma(usuarioSistema.getFlagIdioma())
                .flagEnviaCorreo(usuarioSistema.getFlagEnviaCorreo())
                .claveTemporal(usuarioSistema.getClaveTemporal())
                .flagActivaCuenta(usuarioSistema.getFlagActivaCuenta())
                .fechaActivacion(usuarioSistema.getFechaActivacion())
                .keyActivacion(usuarioSistema.getKeyActivacion())
                .situacionCuenta(usuarioSistema.getSituacionCuenta())
                .keyAcceso(usuarioSistema.getKeyAcceso())
                .flagCuentaVerificada(usuarioSistema.getFlagCuentaVerificada())
                .flagAceptaPoliticaProteccion(usuarioSistema.getFlagAceptaPoliticaProteccion())
                .flagAceptaNovedades(usuarioSistema.getFlagAceptaNovedades())
                .idUsuarioRegistra(usuarioSistema.getIdUsuarioRegistra())
                .fechaRegistra(usuarioSistema.getFechaRegistra())
                .idUsuarioModifica(usuarioSistema.getIdUsuarioModifica())
                .fechaModifica(usuarioSistema.getFechaModifica())
                .situacionRegistro(usuarioSistema.getSituacionRegistro())
                .build();
    }

}
