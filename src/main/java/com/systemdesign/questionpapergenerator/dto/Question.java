package com.systemdesign.questionpapergenerator.dto;


import com.systemdesign.questionpapergenerator.constants.QuestionDifficulty;
import com.systemdesign.questionpapergenerator.constants.Topic;
import lombok.Data;

import javax.validation.constraints.NotNull;

public class Question {

    private String id;
    @NotNull
    private Integer marks;
    @NotNull
    private Topic topic;
    @NotNull
    private String subject;
    @NotNull
    private QuestionDifficulty difficulty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QuestionDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
