import model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.JavaQuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JavaQuestionServiceTest {

    @Autowired
    private JavaQuestionService javaQuestionService;

    @Test
    void testAddQuestion() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.addQuestion(question);
        List<Question> questions = javaQuestionService.getAllQuestions();
        assertTrue(questions.contains(question));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is JVM?", "Java Virtual Machine");
        javaQuestionService.addQuestion(question);
        javaQuestionService.removeQuestion(question);
        List<Question> questions = javaQuestionService.getAllQuestions();
        assertFalse(questions.contains(question));
    }

    @Test
    void testGetRandomQuestion() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");
        javaQuestionService.addQuestion(q1);
        javaQuestionService.addQuestion(q2);

        Question random = javaQuestionService.getRandomQuestion();
        assertNotNull(random);
        assertTrue(random.equals(q1) || random.equals(q2));
    }


}
