package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "TM_PABELLON")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pabellon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PABELLON")
    private Integer idPabellon;

    @Column(name = "NOMBRE_PABELLON")
    private String nombrePabellon;

    @Column(name = "FLAG_IDIOMA")
    private String flagIdioma;

    @Column(name = "ID_USUARIO_MODIFICA")
    private String idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;
}
