package com.questionnaire.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ANSWERS_TO_QUESTIONS")
@Data
@NoArgsConstructor
public class AnswersToQuestions {
    @Id
    @SequenceGenerator(name = "ANSWERS_TO_QUESTIONS_ID_SEQ", sequenceName = "ANSWERS_TO_QUESTIONS_ID_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWERS_TO_QUESTIONS_ID_SEQ")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer Id;

    @Column(name = "ANSWER_ID")
    private Integer AnswerId;

    @Column(name = "QUESTION_ID")
    private Integer QuestionId;

    public AnswersToQuestions(Integer AnswerId, Integer QuestionId) {
        this.AnswerId = AnswerId;
        this.QuestionId = QuestionId;
    }

    @Override
    public String toString() {
        return "AnswersToQuestions{" +
                "Id=" + Id +
                ", AnswerId=" + AnswerId +
                ", QuestionId=" + QuestionId +
                '}';
    }


}
