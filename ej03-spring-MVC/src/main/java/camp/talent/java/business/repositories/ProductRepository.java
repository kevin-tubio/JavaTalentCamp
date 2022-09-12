package camp.talent.java.business.repositories;

import camp.talent.java.business.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
