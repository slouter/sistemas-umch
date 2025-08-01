package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_NIVEL_EDUCATIVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NivelEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NIVEL_EDUCATIVO")
    private int idNivelEducativo;

    @Column(name = "NOMBRE_NIVEL_EDUCATIVO")
    private String nombreNivelEducativo;

}
