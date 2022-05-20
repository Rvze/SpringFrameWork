package com.example.springframeworkcoursehw1.dao;

import com.example.springframeworkcoursehw1.model.Answer;

public class AnswerDAOImpl implements AnswerDAO {
    @Override
    public Answer save(Long id, String ans) {
        return Answer.builder().id(id).ans(ans).build();
    }
}