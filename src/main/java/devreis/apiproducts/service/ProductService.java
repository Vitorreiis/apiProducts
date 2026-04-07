package devreis.apiproducts.service;

import devreis.apiproducts.dto.ProductDTO;
import devreis.apiproducts.model.Product;
import devreis.apiproducts.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO createProduct(ProductDTO request) {
        Product product = new Product();

        product.setId(request.id());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());

        return toDTO(product);

    }

    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(this::toDTO)
                .toList();
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
