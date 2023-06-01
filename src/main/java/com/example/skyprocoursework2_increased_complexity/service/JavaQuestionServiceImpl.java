package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import com.example.skyprocoursework2_increased_complexity.repository.JavaQuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("JavaQuestionServiceImpl")
public class JavaQuestionServiceImpl implements QuestionService{

    private final JavaQuestionRepositoryImpl javaQuestionRepository;
    public JavaQuestionServiceImpl(JavaQuestionRepositoryImpl javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }
    @Override
    public Question remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Random random = new Random();
        Object[] arr = javaQuestionRepository.getAll().toArray();

        return (Question)arr[(random.nextInt(arr.length))];
    }
    @Override
    public int getSize(){
        return javaQuestionRepository.getAll().toArray().length;
    }
}
