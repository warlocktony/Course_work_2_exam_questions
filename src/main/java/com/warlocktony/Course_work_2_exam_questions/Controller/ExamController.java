package com.warlocktony.Course_work_2_exam_questions.Controller;

import com.warlocktony.Course_work_2_exam_questions.Service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examRandomQuestions")
public class ExamController {

    public final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

}
