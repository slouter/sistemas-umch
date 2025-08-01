package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

@Entity
@Data
@Table(name = "TM_USUARIO_SISTEMA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioSistema {

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false)
    private Persona persona;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO_SISTEMA")
    private Integer idUsuarioSistema;

    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "LOGIN_USUARIO_SISTEMA")
    private String loginUsuarioSistema;

    @Column(name = "PASSWORD_USUARIO_SISTEMA")
    private String passwordUsuarioSistema;

    @Column(name = "NUMERO_ALEATORIO")
    private String numeroAleatorio;

    @Column(name = "FLAG_RESTRICCION_HORARIO", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagRestriccionHorario = "N";

    @Column(name = "HORARIO_INICIO_RESTRICCION")
    private Date horarioInicioRestriccion;

    @Column(name = "HORARIO_FINAL_RESTRICCION")
    private Date horarioFinalRestriccion;

    @Column(name = "HORA_INICIO_ACCESO")
    private Time horaInicioAcceso;

    @Column(name = "HORA_FIN_ACCESO")
    private Time horaFinAcceso;

    @Column(name = "FLAG_IDIOMA", columnDefinition = "VARCHAR(2) DEFAULT 'ES'")
    private String flagIdioma = "ES";

    @Column(name = "FLAG_ENVIA_CORREO", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagEnviaCorreo = "N";

    @Column(name = "FECHA_ENVIA_CORREO")
    private Date fechaEnviaCorreo;

    @Column(name = "CLAVE_TEMPORAL", length = 50)
    private String claveTemporal;

    @Column(name = "FLAG_ACTIVA_CUENTA", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagActivaCuenta = "N";

    @Column(name = "FECHA_ACTIVACION")
    private Date fechaActivacion;

    @Column(name = "KEY_ACTIVACION", length = 6)
    private String keyActivacion;

    @Column(name = "SITUACION_CUENTA", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String situacionCuenta = "N";

    @Column(name = "KEY_ACCESO", length = 6)
    private String keyAcceso;

    @Column(name = "FLAG_CUENTA_VERIFICADA", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagCuentaVerificada = "N";

    @Column(name = "FLAG_ACEPTA_POLITICA_PROTECCION", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagAceptaPoliticaProteccion = "N";

    @Column(name = "FLAG_ACEPTA_NOVEDADES", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String flagAceptaNovedades = "N";

    @Column(name = "ID_USUARIO_REGISTRA", columnDefinition = "INT DEFAULT 1")
    private Integer idUsuarioRegistra = 1;

    @Column(name = "FECHA_REGISTRA", columnDefinition = "DATETIME DEFAULT NOW()")
    private Date fechaRegistra = new Date();

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO", columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    private String situacionRegistro = "A";
}