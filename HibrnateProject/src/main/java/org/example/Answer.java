package org.example;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id",insertable = false,nullable = false)
    private int answerId;

    private String answer;

    @ManyToOne
    private Question question;

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
