package com.warlocktony.Course_work_2_exam_questions.service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionLimitExceededException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;

    }

    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new QuestionLimitExceededException("question limit exceeded");
        }


        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
