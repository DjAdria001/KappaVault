
package com.adria.kappavault.repository;

import com.adria.kappavault.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
