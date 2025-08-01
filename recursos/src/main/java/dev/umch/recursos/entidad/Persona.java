package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "TM_PERSONA")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "ID_PAIS")
    private Integer idPais;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS", insertable = false, updatable = false)
    private Pais pais;

    @Column(name = "ID_TIPO_DOCUMENTO")
    private Integer idTipoDocumento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO", insertable = false, updatable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "ID_RELIGION")
    private Integer idReligion;

    @ManyToOne
    @JoinColumn(name = "ID_RELIGION", referencedColumnName = "ID_RELIGION", insertable = false, updatable = false)
    private Religion religion;

    @Column(name = "ID_ESTADO_CIVIL")
    private Integer idEstadoCivil;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO_CIVIL", referencedColumnName = "ID_ESTADO_CIVIL", insertable = false, updatable = false)
    private EstadoCivil estadoCivil;

    @Column(name = "ID_NIVEL_EDUCATIVO")
    private Integer idNivelEducativo;

    @ManyToOne
    @JoinColumn(name = "ID_NIVEL_EDUCATIVO", referencedColumnName = "ID_NIVEL_EDUCATIVO", insertable = false, updatable = false)
    private NivelEducativo nivelEducativo;

    @Column(name = "ID_IDIOMA")
    private Integer idIdioma;

    @ManyToOne
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID_IDIOMA", insertable = false, updatable = false)
    private Idioma idioma;

    @Column(name = "ID_OCUPACION")
    private Integer idOcupacion;

    @ManyToOne
    @JoinColumn(name = "ID_OCUPACION", referencedColumnName = "ID_OCUPACION", insertable = false, updatable = false)
    private Ocupacion ocupacion;

    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "FECHA_VENCIMIENTO_DOCUMENTO")
    private Date fechaVencimiento;

    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FLAG_SEXO")
    private String flagSexo;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "TELEFONO_ALTERNATIVO")
    private String telefonoAlternativo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMAIL_ALTERNATIVO")
    private String emailAlternativo;

    @Column(name = "ID_TIPO_ZONA")
    private Integer idTipoZona;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_ZONA", referencedColumnName = "ID_TIPO_ZONA", insertable = false, updatable = false)
    private TipoZona tipoZona;


    @Column(name = "NOMBRE_ZONA")
    private String nombreZona;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_VIA", referencedColumnName = "ID_TIPO_VIA", insertable = false, updatable = false)
    private TipoVia tipoVia;

    @Column(name = "ID_TIPO_VIA")
    private Integer idTipoVia;

    @Column(name = "NOMBRE_VIA")
    private String nombreVia;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "KILOMETRO")
    private BigDecimal kilometro;

    @Column(name = "MANZANA")
    private String manzana;

    @Column(name = "INTERIOR")
    private String interior;

    @Column(name = "LOTE")
    private String lote;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @Column(name = "OTRO_RELIGION")
    private String otrolReligion;

    @Column(name = "CORREO_INSTITUCIONAL")
    private String correoInstitucional;

    @Column(name = "FOTO")
    private String foto;

    @Column(name = "FLAG_SUSPENDIDA")
    private String flagSuspendida;

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;

    @Column(name = "ID_USUARIO_REGISTRA")
    private Integer idUsuarioRegistra;

    @Column(name = "FECHA_REGISTRA")
    private Date fechaRegistra;

}


