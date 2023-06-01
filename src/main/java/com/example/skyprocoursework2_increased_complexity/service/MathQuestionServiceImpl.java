package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import com.example.skyprocoursework2_increased_complexity.repository.MathQuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("MathQuestionServiceImpl")
public class MathQuestionServiceImpl implements QuestionService{

    private final MathQuestionRepositoryImpl mathQuestionRepository;
    public MathQuestionServiceImpl(MathQuestionRepositoryImpl mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }
    @Override
    public Question remove(String question, String answer) {
        return mathQuestionRepository.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Random random = new Random();
        Object[] arr = mathQuestionRepository.getAll().toArray();

        return (Question)arr[(random.nextInt(arr.length))];
    }
    @Override
    public int getSize(){
        return mathQuestionRepository.getAll().toArray().length;
    }
}
