package com.example.skyprocoursework2_increased_complexity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class QuestionAlreadyAddedException extends RuntimeException{
}
