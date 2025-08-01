package dev.umch.recursos.servicio;

import dev.umch.recursos.entidad.Persona;
import dev.umch.recursos.repositorio.PersonaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonaServicio {

    private final PersonaRepositorio personaRepositorio;

    private static final Logger logger = Logger.getLogger(PersonaServicio.class.getName());

    //agregar metodo para listar todas las personas
    public List<Persona> listarPersonas() {
        var personas = personaRepositorio.findAll();
        logger.info("Listando todas las personas: " + personas.size() + " registros encontrados.");
        return personas.stream()
                .map(this::mapToPersonaResponse)
                .collect(Collectors.toList());
    }

    //agregar metodo para buscar personas por nombre
    public List<Persona> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        return personaRepositorio.findByNombre(nombre);
    }

    public List<Persona> buscarPorDocumento(String numeroDocumento) {
        if (numeroDocumento == null || numeroDocumento.isEmpty()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
        }
        return personaRepositorio.findByNumeroDocumento(numeroDocumento);
    }

    //agregar metodo para agregar una persona
    public void addPersona(Persona persona) {
        var nuevapersona = Persona.builder()
                .idPais(persona.getIdPais())
                .idTipoDocumento(persona.getIdTipoDocumento())
                .idReligion(persona.getIdReligion())
                .idEstadoCivil(persona.getIdEstadoCivil())
                .idNivelEducativo(persona.getIdNivelEducativo())
                .idIdioma(persona.getIdIdioma())
                .idOcupacion(persona.getIdOcupacion())
                .numeroDocumento(persona.getNumeroDocumento())
                .apellidoPaterno(persona.getApellidoPaterno())
                .apellidoMaterno(persona.getApellidoMaterno())
                .nombre(persona.getNombre())
                .flagSexo(persona.getFlagSexo())
                .fechaNacimiento(persona.getFechaNacimiento())
                .telefono(persona.getTelefono())
                .telefonoAlternativo(persona.getTelefonoAlternativo())
                .email(persona.getEmail())
                .emailAlternativo(persona.getEmailAlternativo())
                .idTipoZona(persona.getIdTipoZona())
                .nombreZona(persona.getNombreZona())
                .idTipoVia(persona.getIdTipoVia())
                .nombreVia(persona.getNombreVia())
                .numero(persona.getNumero())
                .kilometro(persona.getKilometro())
                .manzana(persona.getManzana())
                .interior(persona.getInterior())
                .lote(persona.getLote())
                .departamento(persona.getDepartamento())
                .otrolReligion(persona.getOtrolReligion())
                .correoInstitucional(persona.getCorreoInstitucional())
                .foto(persona.getFoto())
                .flagSuspendida(persona.getFlagSuspendida()) // Por defecto, no suspendida
                // Asignar usuario y fecha de registro
                .idUsuarioRegistra(1) // Cambiar según la lógica de tu aplicación
                .fechaRegistra(persona.getFechaRegistra()) // Fecha actual
                // Situación del registro
                .situacionRegistro(persona.getSituacionRegistro()) // Cambiar según la lógica de tu aplicación
                // Usuario y fecha de modificación
                .idUsuarioModifica(1) // Cambiar según la lógica de tu aplicación
                .fechaModifica(persona.getFechaModifica()) // Fecha actual
                .build();

        personaRepositorio.save(nuevapersona);
        log.info("Persona agregada: {}", nuevapersona);
    }

    //agregar metodo para actualizar una persona
    public Persona actualizarPersona(Persona persona) {
        if (persona.getIdPersona()==null){
            throw new IllegalArgumentException("El ID de la persona no puede ser nulo");
        }
        if (!personaRepositorio.existsById(persona.getIdPersona())) {
            throw new IllegalArgumentException("La persona con ID " + persona.getIdPersona() + " no existe");
        }
        return personaRepositorio.save(persona);
    }

    //agregar metodo para eliminar una persona
    public void eliminarPersona(Integer id) {
        if (!personaRepositorio.existsById(id)) {
            throw new IllegalArgumentException("La persona con ID " + id + " no existe");
        }
        personaRepositorio.deleteById(id);
    }

    //agregar metodo para buscar una persona por ID
    public Persona buscarPersonaPorId(Integer id) {
        return personaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La persona con ID " + id + " no existe"));
    }

    public Persona mapToPersonaResponse(Persona persona) {
        return persona.builder()
                .idPersona(persona.getIdPersona())
                .idPais(persona.getIdPais())
                .pais(persona.getPais())
                .idTipoDocumento(persona.getIdTipoDocumento())
                .tipoDocumento(persona.getTipoDocumento())
                .idReligion(persona.getIdReligion())
                .religion(persona.getReligion())
                .idEstadoCivil(persona.getIdEstadoCivil())
                .estadoCivil(persona.getEstadoCivil())
                .idNivelEducativo(persona.getIdNivelEducativo())
                .nivelEducativo(persona.getNivelEducativo())
                .idIdioma(persona.getIdIdioma())
                .idioma(persona.getIdioma())
                .idOcupacion(persona.getIdOcupacion())
                .ocupacion(persona.getOcupacion())
                .numeroDocumento(persona.getNumeroDocumento())
                .apellidoPaterno(persona.getApellidoPaterno())
                .apellidoMaterno(persona.getApellidoMaterno())
                .nombre(persona.getNombre())
                .flagSexo(persona.getFlagSexo())
                .fechaNacimiento(persona.getFechaNacimiento())
                .telefono(persona.getTelefono())
                .telefonoAlternativo(persona.getTelefonoAlternativo())
                .email(persona.getEmail())
                .emailAlternativo(persona.getEmailAlternativo())
                .idTipoZona(persona.getIdTipoZona())
                .tipoZona(persona.getTipoZona())
                .nombreZona(persona.getNombreZona())
                .idTipoVia(persona.getIdTipoVia())
                .tipoVia(persona.getTipoVia())
                .nombreVia(persona.getNombreVia())
                .numero(persona.getNumero())
                .kilometro(persona.getKilometro())
                .manzana(persona.getManzana())
                .interior(persona.getInterior())
                .lote(persona.getLote())
                .departamento(persona.getDepartamento())
                .otrolReligion(persona.getOtrolReligion())
                .correoInstitucional(persona.getCorreoInstitucional())
                .foto(persona.getFoto())
                .flagSuspendida(persona.getFlagSuspendida())
                .idUsuarioModifica(persona.getIdUsuarioModifica())
                .fechaModifica(persona.getFechaModifica())
                .situacionRegistro(persona.getSituacionRegistro())
                .idUsuarioRegistra(persona.getIdUsuarioRegistra())
                .fechaRegistra(persona.getFechaRegistra())
                .build();
    }
}
