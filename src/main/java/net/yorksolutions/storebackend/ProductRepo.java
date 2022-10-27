package net.yorksolutions.storebackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    Iterable<Product> findByDisplayName(String display);
}
