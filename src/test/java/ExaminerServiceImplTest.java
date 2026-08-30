import model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import service.ExaminerServiceImpl;
import service.JavaQuestionService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void testGetQuestions_Success() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");
        when(javaQuestionService.getAllQuestions()).thenReturn(Arrays.asList(q1, q2));
        when(javaQuestionService.getRandomQuestion()).thenReturn(q1, q2);

        List<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(q1));
        assertTrue(result.contains(q2));
    }

    @Test
    void testGetQuestions_ThrowsException() {
        when(javaQuestionService.getAllQuestions()).thenReturn(Arrays.asList(new Question("Q", "A")));

        assertThrows(ResponseStatusException.class, () -> {
            examinerService.getQuestions(2);
        });
    }
}
