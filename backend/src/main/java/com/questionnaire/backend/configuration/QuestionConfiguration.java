package com.questionnaire.backend.configuration;

import com.questionnaire.backend.model.entity.Question;
import com.questionnaire.backend.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository){
        return args -> {
            Question ads = new Question("Why so many ads?");
            Question sleep = new Question("Do you sleep?");
            questionRepository.saveAll(List.of(ads, sleep));
        };
    }
}
