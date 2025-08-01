package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_OCUPACION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ocupacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OCUPACION")
    private int idOcupacion;

    @Column(name = "NOMBRE_OCUPACION")
    private String nombreOcupacion;

}
