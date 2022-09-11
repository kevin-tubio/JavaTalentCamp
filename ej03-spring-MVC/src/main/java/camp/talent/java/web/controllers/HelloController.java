package camp.talent.java.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest() {
        logger.info("Returning hello view");
        return new ModelAndView("hello.jsp");
    }

}
