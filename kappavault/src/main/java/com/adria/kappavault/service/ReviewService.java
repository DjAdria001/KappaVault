package com.adria.kappavault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adria.kappavault.model.Review;
import com.adria.kappavault.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> obtenerTodas() {
        return reviewRepository.findAll();
    }

    public Review guardar(Review review) {
        return reviewRepository.save(review);
    }

    public void eliminar(Long id) {
        reviewRepository.deleteById(id);
    }
}
