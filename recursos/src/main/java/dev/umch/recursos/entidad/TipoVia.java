package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_TIPO_VIA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoVia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_VIA")
    private int idTipoVia;

    @Column(name = "NOMBRE_TIPO_VIA")
    private String nombreTipoVia;

}
