package com.example.eventmanagment.Repository;

import com.example.eventmanagment.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
