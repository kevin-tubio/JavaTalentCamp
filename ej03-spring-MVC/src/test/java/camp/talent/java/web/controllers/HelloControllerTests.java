package camp.talent.java.web.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import camp.talent.java.business.SpringappBusinessConfig;
import camp.talent.java.web.SpringappWebConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class, SpringappWebConfig.class})
@WebAppConfiguration
public class HelloControllerTests {

    @Autowired
    private HelloController controller;

    @Test
    public void testHandleRequestView() {
        ModelAndView modelAndView = controller.handleRequest();
        assertEquals("hello.jsp", modelAndView.getViewName());
    }

}
