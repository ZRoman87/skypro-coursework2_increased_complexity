package com.example.skyprocoursework2_increased_complexity.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.stream.Stream;

import static com.example.skyprocoursework2_increased_complexity.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl javaQuestionServiceImplMock;
    @Mock
    private MathQuestionServiceImpl mathQuestionServiceImplMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    public static Stream<Arguments> shouldReturnCorrectQuestionListSizeParams() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(4, 4)
        );
    }

    public static Stream<Arguments> shouldReturnCorrectJavaQuestionListSizeParams() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2)
        );
    }

    public static Stream<Arguments> shouldReturnCorrectMathQuestionListSizeParams() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2)
        );
    }

    @BeforeEach
    public void beforeEach(){
        when(javaQuestionServiceImplMock.getSize()).thenReturn(2);
        when(mathQuestionServiceImplMock.getSize()).thenReturn(2);
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectQuestionListSizeParams")
    public void shouldReturnCorrectQuestionListSize(int amount, int expected){
        when(javaQuestionServiceImplMock.getRandomQuestion()).thenReturn(QUESTION_1, QUESTION_3);
        when(mathQuestionServiceImplMock.getRandomQuestion()).thenReturn(QUESTION_2, QUESTION_4);

        assertEquals(expected,out.getQuestions(amount).size());
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenBadQuestionsAmountRequested() {
        assertThrows(RuntimeException.class,
                () -> out.getQuestions(5)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectJavaQuestionListSizeParams")
    public void shouldReturnCorrectJavaQuestionListSize(int amount, int expected){
        when(javaQuestionServiceImplMock.getRandomQuestion()).thenReturn(QUESTION_1, QUESTION_3);

        assertEquals(expected,out.getJavaQuestions(amount).size());
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenBadJavaQuestionsAmountRequested() {
        assertThrows(RuntimeException.class,
                () -> out.getJavaQuestions(5)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldReturnCorrectMathQuestionListSizeParams")
    public void shouldReturnCorrectMathQuestionListSize(int amount, int expected){
        when(mathQuestionServiceImplMock.getRandomQuestion()).thenReturn(QUESTION_1, QUESTION_3);

        assertEquals(expected,out.getMathQuestions(amount).size());
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenBadMathQuestionsAmountRequested() {
        assertThrows(RuntimeException.class,
                () -> out.getMathQuestions(5)
        );
    }

}
