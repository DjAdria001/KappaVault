package com.adria.kappavault.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// DEFINE LA CLASE COMO TABLA DE BASE DE DATOS

@Data
// GENERA GETTERS, SETTERS Y TOSTRING AUTOMÁTICAMENTE

@NoArgsConstructor
// CREA CONSTRUCTOR VACÍO

@AllArgsConstructor
// CREA CONSTRUCTOR CON TODOS LOS ATRIBUTOS

public class Review {

    @Id
    // CLAVE PRIMARIA

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID AUTOINCREMENTAL

    private Long id;

    // PUNTUACIÓN DE LA REVIEW
    private int puntuacion;

    // COMENTARIO DEL USUARIO
    private String comentario;

    // ESTADO DE LA OBRA (VISTO, VIENDO, PENDIENTE...)
    private String estado;

    @ManyToOne
    // RELACIÓN MUCHAS REVIEWS A UNA OBRA

    @JoinColumn(name = "obra_id")
    // CREA LA COLUMNA OBRA_ID EN LA BASE DE DATOS

    private Obra obra;
    // OBRA ASOCIADA A LA REVIEW
}
