package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_RELIGION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Religion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RELIGION")
    private int idReligion;

    @Column(name = "NOMBRE_RELIGION")
    private String nombreReligion;

}
