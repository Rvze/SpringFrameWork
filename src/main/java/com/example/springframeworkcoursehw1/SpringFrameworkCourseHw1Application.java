package com.example.springframeworkcoursehw1;

import com.example.springframeworkcoursehw1.model.Answer;
import com.example.springframeworkcoursehw1.service.QuestionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class SpringFrameworkCourseHw1Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringFrameworkCourseHw1Application.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.start();
    }

}
