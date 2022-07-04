package com.example.springframeworkcoursehw1.dao;

import com.example.springframeworkcoursehw1.model.Question;

public interface QuestionDAO {
    Question save(Long id, String question);
}
