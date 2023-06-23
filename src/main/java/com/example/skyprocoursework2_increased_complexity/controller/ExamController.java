package com.example.skyprocoursework2_increased_complexity.controller;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import com.example.skyprocoursework2_increased_complexity.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/get/{amount}")
    public Collection<Question> get(@PathVariable(required = false) int amount) {
        return examinerService.getQuestions(amount);
    }

    @GetMapping(path = "/{subject}/get/{amount}")
    public Collection<Question> get(@PathVariable(required = false) int amount, @PathVariable(required = false) String subject) {
        if (subject.equals("java")) return examinerService.getJavaQuestions(amount);
        if (subject.equals("math")) return examinerService.getMathQuestions(amount);
        else return null;
    }


}
