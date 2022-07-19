package com.example.springframeworkcoursehw1.dao;

import com.example.springframeworkcoursehw1.model.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerDAOImpl implements AnswerDAO {
    @Override
    public Answer save(Long id, String ans) {
        return Answer.builder().id(id).ans(ans).build();
    }
}