package camp.talent.java.business.services;

import camp.talent.java.business.entities.Product;

import java.util.List;

public class SimpleProductManager implements ProductManager {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void increasePrice(int percentage) {
        if (products == null)
            return;

        for (Product product : products) {
            double newPrice = product.getPrice() * (100 + percentage)/100;
            product.setPrice(newPrice);
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
