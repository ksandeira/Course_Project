package service;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService{

    @Autowired
    private JavaQuestionService javaQuestionService;

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = javaQuestionService.getAllQuestions();

        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested amount exceeds available questions");
        }

        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < amount) {
            Question randomQuestion = javaQuestionService.getRandomQuestion();
            selectedQuestions.add(randomQuestion);
        }
        return new ArrayList<>(selectedQuestions);
    }
}
