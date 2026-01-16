package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "TM_AMBIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AMBIENTE")
    private Integer idAmbiente;

    @Column(name = "NOMBRE_AMBIENTE")
    private String nombreAmbiente;

    @Column(name = "CAPACIDAD")
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_AMBIENTE", referencedColumnName = "ID_TIPO_AMBIENTE", insertable = false, updatable = false)
    private TipoAmbiente tipoAmbiente;

    @ManyToOne
    @JoinColumn(name = "ID_PABELLON", referencedColumnName = "ID_PABELLON", insertable = false, updatable = false)
    private Pabellon pabellon;

    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;

    @Column(name = "ID_USUARIO_MODIFICA")
    private Integer idUsuarioModifica;

    @Column(name = "FECHA_MODIFICA")
    private Date fechaModifica;

    @Column(name = "SITUACION_REGISTRO")
    private String situacionRegistro;
}
