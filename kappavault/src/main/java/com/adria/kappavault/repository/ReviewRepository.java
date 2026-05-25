package com.adria.kappavault.repository;

// IMPORTA LA ENTIDAD REVIEW
import org.springframework.data.jpa.repository.JpaRepository;

import com.adria.kappavault.model.Review;

// REPOSITORIO DE REVIEWS
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // HEREDA MÉTODOS CRUD AUTOMÁTICOS:
    // save()
    // findAll()
    // findById()
    // deleteById()
}
