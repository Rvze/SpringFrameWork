package com.example.springframeworkcoursehw1.dao;

import com.example.springframeworkcoursehw1.model.Question;

public class QuestionDAOImpl implements QuestionDAO {
    @Override
    public Question save(Long id, String question) {
        return Question.builder().question(question).id(id).build();
    }
}
