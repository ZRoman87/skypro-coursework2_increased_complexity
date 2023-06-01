package com.example.skyprocoursework2_increased_complexity.repository;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.example.skyprocoursework2_increased_complexity.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionRepositoryImplTest {

    private final MathQuestionRepositoryImpl out = new MathQuestionRepositoryImpl();

    @Test
    public void shouldReturnCorrectQuestionAfterAdd() {
        Question result = out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToAddExistQuestion() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertThrows(RuntimeException.class,
                () -> out.add(QUESTION_TEXT_1, ANSWER_TEXT_1)
        );
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToAddNotCorrectQuestion() {
        assertThrows(RuntimeException.class,
                () -> out.add(QUESTION_TEXT_1, QUESTION_TEXT_1)
        );
    }

    @Test
    public void shouldReturnCorrectQuestionAfterRemove() {
        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        Question result = out.remove(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenTryingToRemoveNotExistQuestion() {
        assertThrows(RuntimeException.class,
                () -> out.remove(QUESTION_TEXT_1, ANSWER_TEXT_1)
        );
    }

    @Test
    public void shouldReturnCorrectQuestionList() {

        out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        out.add(QUESTION_TEXT_2, ANSWER_TEXT_2);

        Collection<Question> result = out.getAll();
        assertIterableEquals(QUESTION_LIST, result);
    }

}
