package com.jnu.questionnaire.service;

import com.jnu.questionnaire.dao.AnswerMapper;
import com.jnu.questionnaire.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    public int addAnswer(Answer answer) {
        return answerMapper.insertAnswer(answer);
    }



}
