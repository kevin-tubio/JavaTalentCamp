package camp.talent.java.business.services;
import java.util.List;

import camp.talent.java.business.entities.Product;
import camp.talent.java.business.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAProductManager implements ProductManager {

    private final ProductRepository productRepository;

    @Autowired
    public JPAProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public void increasePrice(int percentage) {
        List<Product> products = (List<Product>) productRepository.findAll();

        for (Product product : products) {
            double newPrice = product.getPrice() * (100 + percentage) / 100;
            product.setPrice(newPrice);
            productRepository.save(product);
        }
    }

}
