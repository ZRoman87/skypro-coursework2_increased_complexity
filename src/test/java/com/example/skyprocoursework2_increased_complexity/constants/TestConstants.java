package com.example.skyprocoursework2_increased_complexity.constants;

import com.example.skyprocoursework2_increased_complexity.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestConstants {

    public static String QUESTION_TEXT_1 = "Question text 1";
    public static String QUESTION_TEXT_2 = "Question text 2";
    public static String QUESTION_TEXT_3 = "Question text 3";
    public static String QUESTION_TEXT_4 = "Question text 4";
    public static String ANSWER_TEXT_1 = "Answer text 1";
    public static String ANSWER_TEXT_2 = "Answer text 2";
    public static String ANSWER_TEXT_3 = "Answer text 3";
    public static String ANSWER_TEXT_4 = "Answer text 4";

    public static Question QUESTION_1 = new Question(QUESTION_TEXT_1,ANSWER_TEXT_1);
    public static Question QUESTION_2 = new Question(QUESTION_TEXT_2,ANSWER_TEXT_2);
    public static Question QUESTION_3 = new Question(QUESTION_TEXT_3,ANSWER_TEXT_3);
    public static Question QUESTION_4 = new Question(QUESTION_TEXT_4,ANSWER_TEXT_4);

    public static Collection<Question> QUESTION_LIST = new ArrayList<>(List.of(QUESTION_1,QUESTION_2));


}
