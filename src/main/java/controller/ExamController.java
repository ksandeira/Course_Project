package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ExaminerService;
import service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExaminerService examinerService;

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
