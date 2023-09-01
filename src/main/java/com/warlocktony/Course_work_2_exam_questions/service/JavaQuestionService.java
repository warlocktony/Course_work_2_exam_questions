package com.warlocktony.Course_work_2_exam_questions.service;

import com.warlocktony.Course_work_2_exam_questions.DTO.Question;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionAlreadyAddedException;
import com.warlocktony.Course_work_2_exam_questions.Exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {

        this.questions = new HashSet<>();
        this.random = new Random();
    }


    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        return add(q);
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyAddedException("this question already added");
        }
        return question;
    }
    @Override
    public Question remove(Question question){

            boolean q = questions.remove(question);
            if(!q){
                throw new QuestionNotFoundException("question not found");

            }
            return question;
    }



    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {

        int qSize = questions.size();

        int rand = random.nextInt(qSize);
        Question result;
        Object[] q = questions.toArray();
        Object x = q[rand];
        result = (Question) x;
        return result;

    }
}
