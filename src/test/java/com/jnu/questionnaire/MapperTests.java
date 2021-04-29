package com.jnu.questionnaire;

import cn.hutool.core.util.RandomUtil;
import com.jnu.questionnaire.dao.AnswerMapper;
import com.jnu.questionnaire.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = QuestionnaireApplication.class)
public class MapperTests {

    @Autowired
    private AnswerMapper answerMapper;



//    @Test
//    public void testInsertAnswer() {
//        Answer answer = new Answer();
//        String ticket = UUID.randomUUID().toString().replaceAll("-", "").substring(0,4);
//        answer.setTicket(ticket);
//        answer.setTicketStatus(0);
//
//        int rows = answerMapper.insertAnswer(answer);
//        System.out.println(rows);
//    }










}
