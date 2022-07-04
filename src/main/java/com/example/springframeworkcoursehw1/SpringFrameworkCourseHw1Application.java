package com.example.springframeworkcoursehw1;

import com.example.springframeworkcoursehw1.service.QuestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class SpringFrameworkCourseHw1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringFrameworkCourseHw1Application.class, args);
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean("questionService", QuestionService.class);
        questionService.parse();
        questionService.start();
    }

}
