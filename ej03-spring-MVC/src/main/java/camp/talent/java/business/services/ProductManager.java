package camp.talent.java.business.services;

import camp.talent.java.business.entities.Product;

import java.util.List;

public interface ProductManager {

    void increasePrice(int percentage);

    List<Product> getProducts();

}
