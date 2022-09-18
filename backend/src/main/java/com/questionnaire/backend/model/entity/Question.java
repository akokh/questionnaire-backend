package com.questionnaire.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUESTIONS")
@Data
@NoArgsConstructor
public class Question {
    @Id
    @SequenceGenerator(name = "QUESTION_ID_SEQ", sequenceName = "QUESTION_ID_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_ID_SEQ")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer Id; // for internal procedures

    @Column(name = "CONTENT")
    private String content;

    public Question(String content) {
        this.content = content;
    }

    public Question(Integer Id,
                    String content
    ) {
        this.content = content;
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                '}';
    }


}
