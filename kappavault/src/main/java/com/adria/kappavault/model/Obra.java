package com.adria.kappavault.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

public class Obra {

    @Id
    // CLAVE PRIMARIA

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID AUTOINCREMENTAL

    private Long id;

    // TÍTULO DEL ANIME / MANGA
    private String titulo;

    // TIPO DE OBRA
    private String tipo;

    // GÉNERO DE LA OBRA
    private String genero;

    // AÑO DE LANZAMIENTO
    private int anio;

    // URL DE LA IMAGEN
    private String imagenUrl;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    // RELACIÓN 1 A MUCHOS CON REVIEWS

    private List<Review> reviews;
    // LISTA DE RESEÑAS DE LA OBRA
}
