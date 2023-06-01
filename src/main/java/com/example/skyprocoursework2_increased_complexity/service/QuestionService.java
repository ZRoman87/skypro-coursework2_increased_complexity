package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.model.Question;

import java.util.Collection;

public interface QuestionService {

Question add(String question, String answer);
Question remove(String question, String answer);
Collection<Question> getAll();
Question getRandomQuestion();
int getSize();

}
