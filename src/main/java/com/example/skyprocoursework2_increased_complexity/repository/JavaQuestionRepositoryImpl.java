package com.example.skyprocoursework2_increased_complexity.repository;

import com.example.skyprocoursework2_increased_complexity.exception.NotCorrectQuestionException;
import com.example.skyprocoursework2_increased_complexity.exception.QuestionAlreadyAddedException;
import com.example.skyprocoursework2_increased_complexity.exception.QuestionNotFoundException;
import com.example.skyprocoursework2_increased_complexity.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository{

    private final List<Question> questionList;

    public JavaQuestionRepositoryImpl() {
        this.questionList = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {

        Question q;

        if (!question.equals(answer)) {
            q = new Question(question,answer);
        } else {
            throw new NotCorrectQuestionException();
        }

        if (!questionList.contains(q)){
            questionList.add(q);
            return q;
        } else {
            throw new QuestionAlreadyAddedException();
        }

    }
    @Override
    public Question remove(String question, String answer) {

        Question q = new Question(question,answer);

        if (questionList.contains(q)) {
            questionList.remove(q);
            return q;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionList);
    }
}
