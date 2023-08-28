package com.warlocktony.Course_work_2_exam_questions.Service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;

import java.util.Collection;
import java.util.Random;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();


}
