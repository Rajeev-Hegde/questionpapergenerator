package com.systemdesign.questionpapergenerator.service;


import com.systemdesign.questionpapergenerator.dto.QuestionQueryTemplate;
import com.systemdesign.questionpapergenerator.dto.response.TemplateQueryResponse;
import org.springframework.stereotype.Service;

@Service
public interface QuestionQueryService {

    TemplateQueryResponse queryQuestions(QuestionQueryTemplate questionQueryTemplate);
}
