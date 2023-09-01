package com.warlocktony.Course_work_2_exam_questions.service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionLimitExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question1 = new Question("q1", "a1");
    Question question2 = new Question("q2", "a2");

    @Test
    void getQuestions_enoughQuestionsInSet_setOfQuestionsReturned() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(Set.of(question1, question2));

        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(amount, result.size());

    }

    @Test
    void getQuestions_notEnoughQuestionInSet_throwQuestionLimitExceededException() {
        int amount = 1;
        when(questionService.getAll()).thenReturn(Collections.emptyList());
        QuestionLimitExceededException ex = assertThrows(QuestionLimitExceededException.class,
                () -> underTest.getQuestions(amount));
        assertEquals("question limit exceeded", ex.getMessage());

    }


}
