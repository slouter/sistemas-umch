package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_ESTADO_CIVIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_CIVIL")
    private int idEstadoCivil;

    @Column(name = "NOMBRE_ESTADO_CIVIL")
    private String nombreEstadoCivil;

}
