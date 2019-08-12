package com.systemdesign.questionpapergenerator.dto;

import com.systemdesign.questionpapergenerator.constants.QuestionDifficulty;
import com.systemdesign.questionpapergenerator.constants.Topic;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data

/**
 *
 *
 *
 * {
 "marks": 100,
 "topicSubjectFilter": {
 "JAVA": {
 "INHERITANCE": 25.0,
 "SUBJECT2": 30.0
 },
 "OS": {
 "CHAPTER1": 25.0,
 "CHAPTER2": 30.0
 }
 },
 "difficultyFilters": {
 "HIGH": 10.0,
 "MEDIUM": 40.0,
 "EASY": 50.0
 }
 }
 */
public class QuestionQueryTemplate {

    @NotNull
    private Integer marks;

    // ranges from 0.0 to 100.0
    private Map<Topic, Map<String,Double>> topicSubjectFilter = new HashMap<>();
    //ranges from 0.0 to 100.0
    private Map<QuestionDifficulty, Double> difficultyFilters = new HashMap<>();
}
