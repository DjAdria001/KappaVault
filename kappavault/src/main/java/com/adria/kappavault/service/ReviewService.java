
package com.adria.kappavault.service;

import com.adria.kappavault.model.Review;
import com.adria.kappavault.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repo;

    public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

    public List<Review> obtenerTodas() {
        return repo.findAll();
    }

    public Review guardar(Review review) {
        return repo.save(review);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
