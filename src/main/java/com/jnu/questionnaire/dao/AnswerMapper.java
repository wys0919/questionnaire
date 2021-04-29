package com.jnu.questionnaire.dao;

import com.jnu.questionnaire.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {

    int insertAnswer(Answer answer);

}
