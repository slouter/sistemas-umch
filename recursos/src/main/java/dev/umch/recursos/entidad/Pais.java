package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_PAIS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAIS")
    private int idPais;

    @Column(name = "NOMBRE_PAIS")
    private String nombrePais;

}
