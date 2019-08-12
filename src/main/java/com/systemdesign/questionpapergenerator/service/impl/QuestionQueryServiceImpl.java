package com.systemdesign.questionpapergenerator.service.impl;

import com.systemdesign.questionpapergenerator.constants.QuestionDifficulty;
import com.systemdesign.questionpapergenerator.constants.Topic;
import com.systemdesign.questionpapergenerator.dto.Question;
import com.systemdesign.questionpapergenerator.dto.QuestionQueryTemplate;
import com.systemdesign.questionpapergenerator.dto.response.TemplateQueryResponse;
import com.systemdesign.questionpapergenerator.service.QuestionQueryService;
import com.systemdesign.questionpapergenerator.store.QuestionStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {

    @Autowired
    QuestionStoreService questionStoreService;

    @Override
    public TemplateQueryResponse queryQuestions(QuestionQueryTemplate questionQueryTemplate) {

        TemplateQueryResponse templateQueryResponse = new TemplateQueryResponse();

        //make this efficient by storing some attributes as part of key
        Map<String,Question> questionMap= questionStoreService.getAllQuestions();

        Set<Topic> topicsToFilter = !questionQueryTemplate.getTopicSubjectFilter().keySet().isEmpty()?
                questionQueryTemplate.getTopicSubjectFilter().keySet(): new HashSet<>(Arrays.asList(Topic.values()));

        Set<QuestionDifficulty> questionDifficultySet = !questionQueryTemplate.
               getDifficultyFilters().keySet().isEmpty()?questionQueryTemplate.
                getDifficultyFilters().keySet():new HashSet<>(Arrays.asList(QuestionDifficulty.values()));

        Set<Map<String,Double>> subjectFiltersMap= questionQueryTemplate.getTopicSubjectFilter().isEmpty()? null:
                new HashSet<>(questionQueryTemplate.getTopicSubjectFilter().values());

        List<Question> matchingQuestions= questionMap.values().stream()
                .filter(question ->topicsToFilter.contains(question.getTopic()))
                .filter(question ->questionDifficultySet.contains(question.getDifficulty()))
                .collect(Collectors.toList());

        matchingQuestions =getQuestionsByMarksCriteria(matchingQuestions,questionQueryTemplate.getMarks());

//        templateQueryResponse.setData(applyTopicSubDifficultyCriteriaFilter(matchingQuestions,subjectFiltersMap,questionQueryTemplate.
//                getDifficultyFilters()));
        templateQueryResponse.setData(matchingQuestions);

        return templateQueryResponse;
    }


    private List<Question> applyTopicSubDifficultyCriteriaFilter(List<Question> matchingQuestions,Set<Map<String,Double>> subjectFiltersMap,
                                                   Map<QuestionDifficulty,Double>  difficultyDoubleMap){
        //Write this logic
        //and add marks
        return matchingQuestions;
    }



    private List<Question> getQuestionsByMarksCriteria(List<Question> matchingQuestions, int maxMarks){

        //25, 25, 30, 30, 20, 20
        //25, 25, 30, 25, 25, 25
        //check corner cases
        List<Question> res = new ArrayList<>();
        int currentTotal = 0;
        Collections.shuffle(matchingQuestions);

        for (Question question :matchingQuestions){
            if(question.getMarks()+ currentTotal<= maxMarks) {
                res.add(question);
                currentTotal+=question.getMarks();
            }
            if(currentTotal== maxMarks)
                break;
        }
        return res;
    }

//    *
//    private List<Question> getQuestionsByMarksCriteria(List<Question> matchingQuestions, int maxMarks){
//
//        //25, 25, 30, 30, 20, 20
//        //25, 25, 30, 25, 25, 25
//        //check corner cases
//        List<Question> res = new ArrayList<>();
//        int currentTotal = 0;
//        matchingQuestions.sort(Comparator.comparing(Question::getMarks));
//
//
//        int  i, j;
//        for (i = 0; i < matchingQuestions.size(); i++) {
//            Question question = matchingQuestions.get(i);
//
//            for (j = i+1; j < matchingQuestions.size(); j++) {
//                if(currentTotal==maxMarks)
//
//            }
//
//
//            if (question.getMarks() + currentTotal < maxMarks) {
//                res.add(question);
//                currentTotal += question.getMarks();
//            }
//            if (currentTotal == maxMarks)
//                break;
//        }
//        return res;
//    }
//     *
}
