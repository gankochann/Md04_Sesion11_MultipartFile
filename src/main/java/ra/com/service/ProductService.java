package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import ra.com.dto.ProductDto;
import ra.com.dto.ProductUpdateDto;
import ra.com.model.Product;
import ra.com.repository.ipm.ProductRepoIpm;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepoIpm productRepoIpm;

    @Autowired
    private CloudanaryService cloudanaryService;

    public List<Product> findAll(){
        return productRepoIpm.findAllProducts();
    }

    public ProductUpdateDto findById(long id){
        Product product = productRepoIpm.findProductbyId(id);
        ProductUpdateDto productUpdateDto = new ProductUpdateDto(
                product.getId(),
                product.getProductname(),
                product.getPrice(),
                product.getStock(),
                product.getImage(),
                null,
                product.isStatus()
        );
        return productUpdateDto;
    }
    @Transactional
    public boolean update(ProductUpdateDto productUpdateDto){
        String imageUrlUpdate;
        if(productUpdateDto.getImage() != null && !productUpdateDto.getImage().getOriginalFilename().isEmpty()){
            imageUrlUpdate = cloudanaryService.upload(productUpdateDto.getImage());
        }else {
            imageUrlUpdate = productUpdateDto.getOldUrl();
        }
        Product product = new Product(
                productUpdateDto.getId(),
                productUpdateDto.getProductname(),
                productUpdateDto.getPrice(),
                productUpdateDto.getStock(),
                imageUrlUpdate,
                productUpdateDto.isStatus()
        );
        return productRepoIpm.upadateProduct(product);
    }

    @Transactional
    public boolean addProduct(ProductDto productDto , Errors errors){
        if(productDto.getImage() != null || !productDto.getImage().isEmpty()){
            String image = cloudanaryService.upload(productDto.getImage());
            Product product = new Product(
                    productDto.getId(),
                    productDto.getProductname(),
                    productDto.getPrice(),
                    productDto.getStock(),
                    image,
                    productDto.isStatus()
            );
            return productRepoIpm.addProduct(product);
        }else {
            errors.rejectValue("image",null,"image is empty");
            return false;
        }
    }

    @Transactional
    public boolean delete(long id){
        return productRepoIpm.deleteProduct(id);
    }

    public List<Product> findProductByName(String name){
        return productRepoIpm.findProductByname(name);
    }
}
