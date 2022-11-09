package talent.camp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import talent.camp.dto.Student;

import javax.jms.Queue;

@RestController
@RequestMapping("/produce")
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    @PostMapping("/message")
    public Student sendMessage(@RequestBody Student student) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(student);

            jmsTemplate.convertAndSend(queue, studentAsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
