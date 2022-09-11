package camp.talent.java.business;

import java.util.ArrayList;
import java.util.List;

import camp.talent.java.business.entities.Product;
import camp.talent.java.business.services.ProductManager;
import camp.talent.java.business.services.SimpleProductManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringappBusinessConfig {

    private static final Double CHAIR_PRICE = 20.50;
    private static final String CHAIR_DESCRIPTION = "Chair";
    private static final String TABLE_DESCRIPTION = "Table";
    private static final Double TABLE_PRICE = 150.10;

    @Bean
    public ProductManager loadProductManager() {
        SimpleProductManager simpleProductManager = new SimpleProductManager();
        List<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setDescription(CHAIR_DESCRIPTION);
        product.setPrice(CHAIR_PRICE);
        products.add(product);

        product = new Product();
        product.setDescription(TABLE_DESCRIPTION);
        product.setPrice(TABLE_PRICE);
        products.add(product);

        simpleProductManager.setProducts(products);
        return simpleProductManager;
    }

}
