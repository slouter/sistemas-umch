package dev.umch.sisicon.TSG.entidad;

import dev.umch.recursos.entidad.Persona;
import dev.umch.recursos.entidad.TipoAmbiente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "TM_DOCENTE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCENTE")
    private Integer idDocente;

    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", insertable = false, updatable = false)
    private Persona persona;

    @Column(name = "CODIGO_DOCENTE")
    private String codigoDocente;

    @Column(name = "FLAG_IDIOMA")
    private Integer flagIdioma;

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;

}
