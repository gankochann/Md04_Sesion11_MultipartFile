package ra.com.repository.ipm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.com.model.Product;
import ra.com.repository.ProductRepoInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepoIpm implements ProductRepoInterface {
    @Autowired
    ProductRepoIpm productRepoIpm;
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean upadateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(long id) {
        Product product = findProductbyId(id);
        try {
            entityManager.remove(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> productList = entityManager.createQuery("from Product ", Product.class).getResultList();
        return productList;
    }

    @Override
    public Product findProductbyId(long id) {
        Product product = entityManager.createQuery("from Product p where p.id =: id",Product.class)
                .setParameter("id", id).getSingleResult();
        return product;
    }

    @Override
    public List<Product> findProductByname(String name) {
        List<Product> list = entityManager.createQuery("from Product  p where p.productname like concat('%',:name,'%')",Product.class)
                .setParameter("name" , name).getResultList();
        return list;
    }


}
