package com.warlocktony.Course_work_2_exam_questions.service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionAlreadyAddedException;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    JavaQuestionService underTest = new JavaQuestionService();
    Question question1 = new Question("q1", "a1");
    Question question2 = new Question("q2", "a2");

    @Test
    void add__questionAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertTrue(underTest.getAll().contains(question1));
        assertEquals(question1, result);

    }

    @Test
    void add_Question_questionAddedAndReturned() {
        Question result = underTest.add(question2);
        assertTrue(underTest.getAll().contains(question2));
        assertEquals(question2, result);
    }

    @Test
    void add_questionAlreadyInSet_throwQuestionAlreadyAddedException() {
        underTest.add(question1);
        QuestionAlreadyAddedException ex =
                assertThrows(QuestionAlreadyAddedException.class,
                        () -> underTest.add(question1));
        assertEquals("this question already added", ex.getMessage());
    }


    @Test
    void remove__questionAddedAndRemoved() {
        underTest.add(question1.getQuestion(), question1.getAnswer());
        Question result = underTest.remove(question1.getQuestion(), question1.getAnswer());

        assertFalse(underTest.getAll().contains(question1));
        assertEquals(question1, result);
    }

    @Test
    void remove_questionIsNotInSet_throwQuestionNotFoundException() {
        QuestionNotFoundException ex =
                assertThrows(QuestionNotFoundException.class,
                        () -> underTest.remove("q", "a"));
        assertEquals("question not found", ex.getMessage());

    }

    @Test
    void getAll_questionsAreInSet_setWithQuestionReturned() {
        underTest.add(question1);
        underTest.add(question2);

        Collection<Question> result = underTest.getAll();

        assertTrue(result.containsAll(Set.of(question1, question2)));

    }

    @Test
    void getAll_questionsAreNotInSet_setWithQuestionReturned() {

        Collection<Question> result = underTest.getAll();

        assertTrue(result.containsAll(Set.of()));

    }

    @Test
    void getRandomQuestion_addQuestion_checkResultWithGetRandomQuestion() {
        underTest.add(question1);
        Question result = underTest.getRandomQuestion();
        assertEquals(result, question1);


    }


}
