package com.warlocktony.Course_work_2_exam_questions.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "this question already added")
public class QuestionAlreadyAddedException extends RuntimeException {
    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
