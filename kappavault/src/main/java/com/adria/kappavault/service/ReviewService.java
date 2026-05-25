package com.adria.kappavault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adria.kappavault.model.Review;
import com.adria.kappavault.repository.ReviewRepository;

@Service
// DEFINE LA CLASE COMO SERVICIO DE SPRING
public class ReviewService {

    // REPOSITORIO DE REVIEWS
    private final ReviewRepository repo;

    // INYECCIÓN DEL REPOSITORIO
    public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

    // OBTENER TODAS LAS REVIEWS
    public List<Review> obtenerTodas() {
        return repo.findAll();
    }

    // GUARDAR REVIEW EN LA BASE DE DATOS
    public Review guardar(Review review) {
        return repo.save(review);
    }

    // ELIMINAR REVIEW POR ID
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
