package com.warlocktony.Course_work_2_exam_questions.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "question limit exceeded")
public class QuestionLimitExceededException extends RuntimeException{
    public QuestionLimitExceededException(String message){
        super(message);
    }
}
