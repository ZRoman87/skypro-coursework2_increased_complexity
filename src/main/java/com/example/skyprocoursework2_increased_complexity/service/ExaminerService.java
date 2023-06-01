package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getJavaQuestions(int amount);
    Collection<Question> getMathQuestions(int amount);
    Collection<Question> getQuestions(int amount);

}
