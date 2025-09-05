package ra.com.repository;

import ra.com.model.Product;

import java.util.List;

public interface ProductRepoInterface {
    boolean addProduct(Product product);

    boolean upadateProduct(Product product);

    boolean deleteProduct(long id);

    List<Product> findAllProducts();

    Product findProductbyId(long id);

    List<Product> findProductByname(String name);
}
