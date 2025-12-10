package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.JavaQuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @Autowired
    private JavaQuestionService javaQuestionService;

    @PostMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.addQuestion(new Question(question, answer));
    }

    @PostMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public List<Question> getAllQuestion() {
        return javaQuestionService.getAllQuestions();
    }
}
