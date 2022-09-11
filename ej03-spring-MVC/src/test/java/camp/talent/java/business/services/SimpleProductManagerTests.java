package camp.talent.java.business.services;

import java.util.ArrayList;
import java.util.List;

import camp.talent.java.business.entities.Product;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleProductManagerTests {

    private SimpleProductManager productManager;

    private static final int PRODUCT_COUNT = 2;
    private static final Double CHAIR_PRICE = 20.50;
    private static final String CHAIR_DESCRIPTION = "Chair";
    private static final String TABLE_DESCRIPTION = "Table";
    private static final Double TABLE_PRICE = 150.10;
    private static final int POSITIVE_PRICE_INCREASE = 10;

    @Before
    public void setUp() {
        productManager = new SimpleProductManager();
        List<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setDescription(CHAIR_DESCRIPTION);
        product.setPrice(CHAIR_PRICE);
        products.add(product);

        product = new Product();
        product.setDescription(TABLE_DESCRIPTION);
        product.setPrice(TABLE_PRICE);
        products.add(product);

        productManager.setProducts(products);
    }

    @Test
    public void testGetProductsWithNoProducts() {
        productManager = new SimpleProductManager();
        assertNull(productManager.getProducts());
    }

    @Test
    public void testGetProducts() {
        List<Product> products = productManager.getProducts();
        assertNotNull(products);
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice());

        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());
    }

    @Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        } catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        } catch(Exception ex) {
            fail("Products list is empty.");
        }
    }

    @Test
    public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;

        List<Product> products = productManager.getProducts();
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

        product = products.get(1);
        assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
    }

}
