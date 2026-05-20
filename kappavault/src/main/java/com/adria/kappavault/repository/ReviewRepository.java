package com.adria.kappavault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adria.kappavault.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
