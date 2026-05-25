
package com.adria.kappavault.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int puntuacion;
    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;
}
