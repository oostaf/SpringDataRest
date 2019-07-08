package com.example.SpringDataRest.repository;

import com.example.SpringDataRest.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long> {
}
