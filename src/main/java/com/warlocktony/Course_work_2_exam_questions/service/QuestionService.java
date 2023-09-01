package com.warlocktony.Course_work_2_exam_questions.service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();


}
