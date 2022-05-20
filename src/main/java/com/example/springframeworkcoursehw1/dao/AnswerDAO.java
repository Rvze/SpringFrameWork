package com.example.springframeworkcoursehw1.dao;

import com.example.springframeworkcoursehw1.model.Answer;

public interface AnswerDAO {
    Answer save(Long id, String ans);
}
