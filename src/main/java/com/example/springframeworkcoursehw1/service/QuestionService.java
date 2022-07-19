package com.example.springframeworkcoursehw1.service;


import com.example.springframeworkcoursehw1.model.Answer;
import com.example.springframeworkcoursehw1.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> parseQuestions();

    List<Answer> start();
}
