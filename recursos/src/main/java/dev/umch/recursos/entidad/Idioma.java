package dev.umch.recursos.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "TM_IDIOMA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IDIOMA")
    private int idIdioma;

    @Column(name = "NOMBRE_IDIOMA")
    private String nombreIdioma;

    @Column(name = "NOMBRE_CORTO_IDIOMA")
    private String nombreCortoIdioma;

}