package com.warlocktony.Course_work_2_exam_questions.Service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions() {
        for (int i = 0; i <= ; i++) {

        }

        return ;
    }
}
