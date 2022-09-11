package camp.talent.java.web.controllers;

import camp.talent.java.business.services.ProductManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());
    private final ProductManager productManager;

    @Autowired
    public InventoryController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest() {
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
    }

}
