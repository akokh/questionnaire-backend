package com.questionnaire.backend.service.implementation;

import com.questionnaire.backend.model.entity.Question;
import com.questionnaire.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestion(){
        return questionRepository.findAll();
    }

    public void addNewQuestion(Question question) {
        Optional<Question> questionById = questionRepository.findQuestionById(question.getId());
        if(questionById.isPresent()){
            throw new IllegalStateException("Cant add question. Id is used by another Question " + question.getId());
        }
        questionRepository.save(question);
        System.out.println(question);
    }

    public void deleteQuestion(Integer questionId) {
        boolean exists = questionRepository.existsById(questionId);
        if(!exists){
            throw new IllegalStateException("Can't delete question. Question with id " + questionId + " does not exists");
        }
        questionRepository.deleteById(questionId);
    }

    @Transactional
    public void updateQuestion(Integer questionId, String content) {
        Question question = questionRepository.findQuestionById(questionId).orElseThrow(
                () -> new IllegalStateException("Can't update. Question with id " + questionId + " does not exists")
        );
        if(content != null && content.length() > 0 && !Objects.equals(question.getContent(), content) ){
            question.setContent(content);
        }
    }
}
