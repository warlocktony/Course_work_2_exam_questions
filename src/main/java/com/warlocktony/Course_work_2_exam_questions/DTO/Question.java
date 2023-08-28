package com.warlocktony.Course_work_2_exam_questions.DTO;

import java.util.Objects;



public class Question{
    private String question;
    private String answer;

    public Question(String question, String answer){
        this.question=question;
        this.answer=answer;

    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question questions = (Question) o;
        return Objects.equals(question, questions.question) && Objects.equals(answer, questions.answer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
    @Override
    public String toString() {
        return question + " " + answer;
    }

}
