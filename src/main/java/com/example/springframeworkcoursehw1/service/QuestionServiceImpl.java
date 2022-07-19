package com.example.springframeworkcoursehw1.service;

import au.com.bytecode.opencsv.CSVReader;
import com.example.springframeworkcoursehw1.dao.AnswerDAO;
import com.example.springframeworkcoursehw1.dao.QuestionDAO;
import com.example.springframeworkcoursehw1.model.Answer;
import com.example.springframeworkcoursehw1.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDAO questionDAO;
    private final AnswerDAO answerDAO;
    private final String questionsfileName;
    private final String answersfileName;

    @Autowired
    public QuestionServiceImpl(QuestionDAO questionDAO, AnswerDAO answerDAO, @Value("${path.questions}") String questionsfileName, @Value("${path.answers}") String answersfileName) {
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
        this.questionsfileName = questionsfileName;
        this.answersfileName = answersfileName;
    }

    @Override
    public List<Question> parseQuestions() {
        List<Question> questionList = new ArrayList<>();
        try {
            CSVReader questionReader = new CSVReader(new FileReader(questionsfileName), ',', '"', 1);
            String[] nextLine;
            while ((nextLine = questionReader.readNext()) != null) {
                Question question = questionDAO.save(Long.valueOf(nextLine[0]), nextLine[1]);
                question.setId(Long.valueOf(nextLine[0]));
                question.setQuestion(nextLine[1]);
                questionList.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;

    }

    public List<Answer> parseAnswers() {
        List<Answer> answerList = new ArrayList<>();
        try {
            CSVReader questionReader = new CSVReader(new FileReader(answersfileName), ',', '"', 1);
            String[] nextLine;
            while ((nextLine = questionReader.readNext()) != null) {
                Answer answer = answerDAO.save(Long.valueOf(nextLine[0]), nextLine[1]);
                answer.setId(Long.valueOf(nextLine[0]));
                answer.setAns(nextLine[1].strip().toLowerCase());
                answerList.add(answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answerList;
    }

    @Override
    public List<Answer> start() {
        List<Question> questions = parseQuestions();

        Scanner scanner = new Scanner(System.in);
        List<Answer> answerList = new ArrayList<>();
        String str;
        int i = 0;
        for (Question question1 : questions) {
            System.out.println(question1.getId() + " " + question1.getQuestion());
            str = scanner.nextLine().strip().toLowerCase();
            checkAns(str, i);
            Answer answer = answerDAO.save(question1.getId(), str);
            answerList.add(answer);
            i++;
        }
        return answerList;
    }

    public void checkAns(String answer, int i) {
        List<Answer> answers = parseAnswers();
        if (answers.get(i).getAns().equals(answer)) {
            System.out.println("Верно!");
            answers.get(i).setAnswer(true);
        } else {
            System.out.println("Неверно!");
            answers.get(i).setAnswer(false);
        }
    }
}