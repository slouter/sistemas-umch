package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_TIPO_DOCUMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_DOCUMENTO")
    private int idTipoDocumento;

    @Column(name = "NOMBRE_TIPO_DOCUMENTO")
    private String nombreTipoDocumento;

}
