package com.questionnaire.backend.controller;


import com.questionnaire.backend.model.entity.Question;
import com.questionnaire.backend.service.implementation.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.QuitEvent;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;

    }
    @GetMapping
    public List<Question> hello(){
        return questionService.getQuestion();
    }

    @PostMapping
    public void registerQuestion(@RequestBody Question question){
        questionService.addNewQuestion(question);
    }

    @DeleteMapping(path = "{questionId}")
    public void deleteQuestion(@PathVariable ("questionId")  Integer quesitionId){
        questionService.deleteQuestion(quesitionId);
    }

    @PutMapping(path = "{questionId}")
    public void updateQuestion(@PathVariable ("questionId") Integer questionId,
                               @RequestParam(required = false) String content
                               ){
        questionService.updateQuestion(questionId, content);
    }
}

