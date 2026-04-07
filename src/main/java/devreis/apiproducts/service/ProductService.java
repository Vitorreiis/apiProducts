package devreis.apiproducts.service;

import devreis.apiproducts.dto.ProductDTO;
import devreis.apiproducts.model.Product;
import devreis.apiproducts.repository.ProductRepository;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
