package com.warlocktony.Course_work_2_exam_questions.Controller;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import com.warlocktony.Course_work_2_exam_questions.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    public final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    //Почему и как метод указывает на интерфейс, а не на реализацию?
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer){
        return questionService.remove(question,answer);
    }
    @GetMapping()
    public Collection<Question> qetAll(){
        return questionService.getAll();
    }

}
