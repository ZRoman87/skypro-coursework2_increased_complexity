package com.example.skyprocoursework2_increased_complexity.controller;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import com.example.skyprocoursework2_increased_complexity.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathController {

    private final QuestionService questionService;

    public MathController(@Qualifier("MathQuestionServiceImpl") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(required = false) String question,
                        @RequestParam(required = false) String answer
    ) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(required = false) String question,
                           @RequestParam(required = false) String answer
    ) {
        return questionService.remove(question, answer);
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}
