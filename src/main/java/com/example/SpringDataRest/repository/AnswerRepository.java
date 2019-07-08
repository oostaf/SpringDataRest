package com.example.SpringDataRest.repository;

import com.example.SpringDataRest.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
