package com.questionnaire.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ANSWERS")
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @SequenceGenerator(name = "ANSWER_ID_SEQ", sequenceName = "ANSWER_ID_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_ID_SEQ")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer Id; // for internal procedures

    @Column(name = "CONTENT")
    private String content;

    public Answer(String content) {
        this.content = content;
    }

    public Answer(String content,
                    Integer Id) {
        this.content = content;
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                '}';
    }


}
