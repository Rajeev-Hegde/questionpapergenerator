package com.systemdesign.questionpapergenerator.dto.response;

import com.systemdesign.questionpapergenerator.dto.Question;
import lombok.Data;

import java.util.List;

/**
 * This class will
 */
@Data
public class TemplateQueryResponse {

    private List<Question> data;

}
