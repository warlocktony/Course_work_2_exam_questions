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
    public Question remove(String question, String answer){
            Question que = new Question(question,answer);
            boolean q = questions.remove(que);
            if(!q){
                throw new QuestionNotFoundException("question not found");

            }
            return que;
    }

//    @Override
//    public Question remove(Question question) {
//        boolean result = questions.remove(question);// true если элемент был
//        // false если элемента нет
//        if (!result) {
//            throw new QuestionNotFoundException("question not found");
//        }
//        return question;
//    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
//        int i = 0;
//        int qSize = questions.size();
//        Random r = new Random();
//        int rand = r.nextInt(qSize);
//        for (Question q : questions) {
//            if (i == rand)
//                return q;
//            i++;
//        }


        int qSize = questions.size();

        int rand = random.nextInt(qSize);
        Question result;
        Object[] q = questions.toArray();
        Object x = q[rand];
        result = (Question) x;
        return result;
//        return (Question) questions.toArray()[new Random().nextInt(questions.size())];
    }
}
