package com.questionnaire.backend.repository;

import com.questionnaire.backend.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.Id = ?1")
    Optional<Question> findQuestionById(Integer Id);

}
