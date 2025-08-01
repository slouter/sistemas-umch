package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_TIPO_ZONA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoZona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_ZONA")
    private int idTipoZona;

    @Column(name = "NOMBRE_TIPO_ZONA")
    private String nombreTipoZona;

}
