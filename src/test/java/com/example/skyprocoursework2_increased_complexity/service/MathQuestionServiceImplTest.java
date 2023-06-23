package com.example.skyprocoursework2_increased_complexity.service;

import com.example.skyprocoursework2_increased_complexity.model.Question;
import com.example.skyprocoursework2_increased_complexity.repository.MathQuestionRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static com.example.skyprocoursework2_increased_complexity.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceImplTest {
    @Mock
    private MathQuestionRepositoryImpl mathQuestionRepositoryImplMock;
    @InjectMocks
    private MathQuestionServiceImpl out;

    @Test
    public void shouldReturnCorrectQuestionAfterAdd() {
        when(mathQuestionRepositoryImplMock.add(QUESTION_TEXT_1, ANSWER_TEXT_1)).thenReturn(QUESTION_1);
        Question result = out.add(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }
    @Test
    public void shouldReturnCorrectQuestionAfterRemove() {
        when(mathQuestionRepositoryImplMock.remove(QUESTION_TEXT_1, ANSWER_TEXT_1)).thenReturn(QUESTION_1);
        Question result = out.remove(QUESTION_TEXT_1, ANSWER_TEXT_1);
        assertEquals(QUESTION_1, result);
    }
    @Test
    public void shouldReturnCorrectQuestionList() {

        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(QUESTION_LIST);
        Collection<Question> result = out.getAll();
        assertIterableEquals(QUESTION_LIST, result);
    }

    @Test
    public void shouldReturnCorrectRandomQuestion() {
        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(QUESTION_LIST);
        Question q = out.getRandomQuestion();
        boolean result = (q.equals(QUESTION_1) | q.equals(QUESTION_2) | q.equals(QUESTION_3));
        assertTrue(result);
    }
    @Test
    public void shouldReturnCorrectListSize() {
        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(QUESTION_LIST);
        int result = out.getSize();
        assertEquals(2, result);
    }

}
