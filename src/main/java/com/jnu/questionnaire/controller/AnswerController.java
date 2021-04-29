package com.jnu.questionnaire.controller;


import com.jnu.questionnaire.entity.Answer;
import com.jnu.questionnaire.service.AnswerService;
import com.jnu.questionnaire.util.CookieUtil;
import com.jnu.questionnaire.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(path = "/ans")
    public String getQuestionnaire() {
        return "query";
    }



//    @RequestMapping(path = "/ans")
//    public String getQuestionnaire(@Param("ticket") String ticket, HttpServletRequest request, HttpServletResponse response) {
//        if (ticket==null || "".equals(ticket)) {
//            ticket = CookieUtil.getValue(request,"ticket_cookie");
//            System.out.println("cookie:ticket=======" + ticket);
//        }
//        System.out.println("ticket=======" + ticket);
//        Object status = answerService.queryStatus(ticket);
//        if (status == null) {
//            return "error";
//        } else if ((int)status == 1) {
//            return "complete";
//        }
//        Cookie cookie = new Cookie("ticket_cookie", ticket);
//        cookie.setMaxAge(86400);
//        cookie.setPath(contextPath);
//        response.addCookie(cookie);
//        return "query";
//    }



//    @RequestMapping("/submit")
//    public String submit(Answer answer, HttpServletRequest request) {
//        if (answer.getQ01()==null) return "thanks";
//
//        String ticket = CookieUtil.getValue(request,"ticket_cookie");
//        if (ticket == null) {
//            return "retry";
//        }
//        answer.setTicket(ticket);
//
//        answer.setTicketStatus(1);
//        answer.setSubmitTime(DateUtil.dateToString(new Date()));
//        answerService.modifyAnswer(answer);
//        return "thanks";
//    }


    @RequestMapping("/submit")
    public String submit(Answer answer, HttpServletRequest request, HttpServletResponse response) {
        //防止微信重复提交
        if (answer.getQ01()==null) return "thanks";

        //防止点击浏览器刷新按钮重复提交
        String SubmitTimeCookie = CookieUtil.getValue(request,"SubmitTimeCookie");
        if (SubmitTimeCookie != null) {
            long timeDiff = new Date().getTime() - DateUtil.stringToDate(SubmitTimeCookie).getTime();
            if (timeDiff < 30000) return "complete";
        }

        //提交答案并保存Cookie
        String submitTime = DateUtil.dateToString(new Date());
        answer.setSubmitTime(submitTime);
        answerService.addAnswer(answer);
        Cookie cookie = new Cookie("SubmitTimeCookie", submitTime);
        cookie.setMaxAge(86400);
        cookie.setPath(contextPath);
        response.addCookie(cookie);
        return "thanks";
    }




//    @RequestMapping("/generate")
//    @ResponseBody
//    public String generateTicket() {
//        Answer answer = new Answer();
//        //生成4为随机字符串作为ticket
//        String ticket = RandomUtil.randomNumbers(4);
//        answer.setTicket(ticket);
//        answer.setTicketStatus(0);
//        answerService.addAnswer(answer);
//        int id = answerService.queryId(ticket);
//        return "编号：" + id + "，     验证码：" + ticket;
//    }

}
