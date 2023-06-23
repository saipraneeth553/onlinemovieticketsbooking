package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.movie.entity.Feedback;

public interface FeedbackRepositary extends JpaRepository<Feedback, Long>{

}
