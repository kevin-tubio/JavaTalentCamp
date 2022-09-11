package camp.talent.java.web.controllers;

import javax.validation.Valid;

import camp.talent.java.business.services.PriceIncrease;
import camp.talent.java.business.services.ProductManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/priceincrease.htm")
public class PriceIncreaseFormController {

    protected final Log logger = LogFactory.getLog(getClass());

    private final ProductManager productManager;

    @Autowired
    public PriceIncreaseFormController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @PostMapping
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result) {
        if (result.hasErrors()) {
            return "priceincrease";
        }

        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/hello.htm";
    }

    @GetMapping
    protected PriceIncrease formBackingObject() {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

}
