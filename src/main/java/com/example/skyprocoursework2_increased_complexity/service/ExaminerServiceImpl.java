package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.exception.BadQuestionsAmountException;
import com.example.skyprocoursework2_increased_complexity.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final JavaQuestionServiceImpl javaQuestionService;
    private final MathQuestionServiceImpl mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionService, MathQuestionServiceImpl mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount){

        Question q;

        int javaSize = javaQuestionService.getSize();
        int mathSize = mathQuestionService.getSize();

        //System.out.println("amount = " + amount);
        //System.out.println("javaSize = " + javaSize);
        //System.out.println("mathSize = " + mathSize);

        Random random = new Random();
        int javaAmount;
        List<Question> questionList = new ArrayList<>();

        if ((javaSize + mathSize) <= 0 || amount > (javaSize + mathSize) || amount <= 0) {
            throw new BadQuestionsAmountException();
        }

        if (javaSize == 0) {
            javaAmount = 0;
        } else {

            do {

                if (amount < javaSize) {
                    javaAmount = random.nextInt(amount);
                } else {
                    javaAmount = random.nextInt(javaSize + 1);
                }
                //System.out.println("javaAmount = " + javaAmount);
            } while ((amount - javaAmount) > mathSize);
        }

        //System.out.println("javaAmount = " + javaAmount);

            while (questionList.size() < javaAmount){
                q = javaQuestionService.getRandomQuestion();
                //System.out.println("java q = " + q.toString());
                if (!questionList.contains(q)) {
                    questionList.add(q);
                    //System.out.println("java q added");
                }
            }
            while (questionList.size() != amount) {
                q = mathQuestionService.getRandomQuestion();
                //System.out.println("math q = " + q.toString());
                //System.out.println("questionList.size() = " + questionList.size());
                if (!questionList.contains(q)) {
                    questionList.add(q);
                    //System.out.println("math q added");
                }
            }
            return questionList;
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        return getSubjectQuestions(amount, javaQuestionService);
    }

    @Override
    public Collection<Question> getMathQuestions(int amount) {
        return getSubjectQuestions(amount, mathQuestionService);
    }

    private Collection<Question> getSubjectQuestions(int amount, QuestionService questionService) {

        Question q;
        List<Question> questionList = new ArrayList<>();

        if (amount > questionService.getSize() || amount <= 0) {
            throw new BadQuestionsAmountException();
        } else {
            while (questionList.size() != amount) {
                q = questionService.getRandomQuestion();
                if (!questionList.contains(q)) {
                    questionList.add(q);
                }
            }
            return questionList;
        }
    }
}
