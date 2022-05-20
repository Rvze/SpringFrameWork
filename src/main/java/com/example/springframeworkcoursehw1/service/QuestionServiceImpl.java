package com.example.springframeworkcoursehw1.service;

import au.com.bytecode.opencsv.CSVReader;
import com.example.springframeworkcoursehw1.dao.AnswerDAO;
import com.example.springframeworkcoursehw1.dao.QuestionDAO;
import com.example.springframeworkcoursehw1.model.Answer;
import com.example.springframeworkcoursehw1.model.Question;
import lombok.RequiredArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private List<Question> questionList;
    private Question question;
    private final QuestionDAO questionDAO;
    private final AnswerDAO answerDAO;
    private final String fileName;
    private Scanner scanner;
    private List<Answer> answerList;
    private Answer answer;


    @Override
    public void parse() {
        questionList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                question = questionDAO.save(Long.valueOf(nextLine[0]), nextLine[1]);
                question.setId(Long.valueOf(nextLine[0]));
                question.setQuestion(nextLine[1]);
                questionList.add(question);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        answerList = new ArrayList<>();
        String str;
        for (Question question1 : questionList) {
            System.out.println(question1.getId() + " " + question1.getQuestion());
            str = scanner.nextLine();
            answer = answerDAO.save(question1.getId(), str);
            answerList.add(answer);
        }
    }
}
