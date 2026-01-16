package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "TM_TIPO_AMBIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoAmbiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_AMBIENTE")
    private Integer idTipoAmbiente;

    @Column(name = "NOMBRE_TIPO_AMBIENTE")
    private String nombreTipoAmbiente;

    @Column(name = "FLAG_IDIOMA")
    private Integer flagIdioma;

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;
}
