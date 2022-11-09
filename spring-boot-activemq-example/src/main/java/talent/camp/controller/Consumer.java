package talent.camp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import talent.camp.dto.Student;

import javax.jms.Queue;

@RestController
@RequestMapping("/consume")
@RequiredArgsConstructor
public class Consumer {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    @GetMapping("/message")
    public Student consumeMessage() {

        Student student = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
            student = mapper.readValue(jsonMessage, Student.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
