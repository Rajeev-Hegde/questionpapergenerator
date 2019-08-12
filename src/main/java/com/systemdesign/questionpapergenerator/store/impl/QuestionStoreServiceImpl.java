package com.systemdesign.questionpapergenerator.store.impl;

import com.systemdesign.questionpapergenerator.dto.Question;
import com.systemdesign.questionpapergenerator.store.QuestionStoreService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class QuestionStoreServiceImpl implements QuestionStoreService{


    //In memory data store used here as of now, since db connection is not allowed
    private Map<String,Question> questionStore = new ConcurrentHashMap<>();

    public QuestionStoreServiceImpl() {

        //load default questions here if need be
    }

    @Override
    public Question addQuestion(Question question) throws Exception {

        if(question!=null){
            if(question.getId()!=null && questionStore.containsKey(question.getId()))
                throw new Exception("Question with id is already present. If you are adding question with id, add unique id");

            //For simplicity considering time stamp and random number
            String id = question.getId()!=null? question.getId(): String.valueOf(System.currentTimeMillis()+"_" +new Random().nextInt(Integer.MAX_VALUE));
            this.questionStore.put(id,question);
            return question;
        }
        return null;
    }

    @Override
    public boolean removeQuestion(String questionId) throws Exception {

        if(questionId!=null){
            if(this.questionStore.containsKey(questionId)){
                this.questionStore.remove(questionId);
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Question> getAllQuestions() {
        return this.questionStore;
    }


}
