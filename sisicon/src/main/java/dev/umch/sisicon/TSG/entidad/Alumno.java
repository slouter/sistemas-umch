package dev.umch.sisicon.TSG.entidad;

import jakarta.persistence.*;
import lombok.*;
import dev.umch.recursos.entidad.Persona;

import java.util.Date;

@Entity
@Data
@Table(name = "TM_ALUMNO")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUMNO")
    private Integer idAlumno;

    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false)
    private Persona persona;

    @Column(name = "CODIGO_ALUMNO")
    private String codigoAlumno;

    @Column(name = "FLAG_GENERA_USUARIO")
    private String flagGeneraUsuario;

    @Column(name = "FLAG_IDIOMA")
    private String flagIdioma;

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;

}
