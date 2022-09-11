package camp.talent.java.web.controllers;

import static org.junit.Assert.*;

import camp.talent.java.business.SpringappBusinessConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import camp.talent.java.web.SpringappWebConfig;

import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringappBusinessConfig.class, SpringappWebConfig.class })
@WebAppConfiguration
public class InventoryControllerTests {

    @Autowired
    private InventoryController controller;

    @Test
    public void testHandleRequestView() {
        ModelAndView modelAndView = controller.handleRequest();
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map<String, Object> modelMap = getModelMap(modelAndView);
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getModelMap(ModelAndView modelAndView) {
        return (Map<String, Object>) modelAndView.getModel().get("model");
    }

}
