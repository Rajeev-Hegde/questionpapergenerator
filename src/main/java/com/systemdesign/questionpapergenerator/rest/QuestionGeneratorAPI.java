package com.systemdesign.questionpapergenerator.rest;


import com.systemdesign.questionpapergenerator.dto.Question;
import com.systemdesign.questionpapergenerator.dto.QuestionQueryTemplate;
import com.systemdesign.questionpapergenerator.dto.response.TemplateQueryResponse;
import com.systemdesign.questionpapergenerator.service.QuestionQueryService;
import com.systemdesign.questionpapergenerator.store.QuestionStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/question")
public class QuestionGeneratorAPI {

    private final QuestionQueryService questionQueryService;

    private final QuestionStoreService questionStoreService;

    @Autowired
    public QuestionGeneratorAPI(QuestionQueryService questionQueryService, QuestionStoreService questionStoreService) {
        this.questionQueryService = questionQueryService;
        this.questionStoreService = questionStoreService;
    }

    //api/v1/question/query
    @PostMapping("/query")
    public TemplateQueryResponse queryQuestions(@RequestBody @Valid QuestionQueryTemplate questionQueryTemplate){
        return  questionQueryService.queryQuestions(questionQueryTemplate);
    }


    @PostMapping("/add")
    public Question addQuestion(@RequestBody @Valid Question question) throws Exception {
        return questionStoreService.addQuestion(question);
    }

    @GetMapping("/remove/{questionId}")
    public boolean removeQuestion(@PathVariable("questionId") String questionId) throws Exception {
        return questionStoreService.removeQuestion(questionId);
    }
}
