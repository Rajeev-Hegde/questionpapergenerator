package com.systemdesign.questionpapergenerator.store;

import com.systemdesign.questionpapergenerator.dto.Question;

import java.util.Map;

public interface QuestionStoreService {


    Question addQuestion(Question question) throws Exception;

    boolean removeQuestion(String questionId) throws Exception;

    Map<String, Question> getAllQuestions();
}
