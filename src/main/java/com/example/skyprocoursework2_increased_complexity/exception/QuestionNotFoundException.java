package com.example.skyprocoursework2_increased_complexity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFoundException extends RuntimeException{
}
