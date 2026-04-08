package devreis.apiproducts.service;

import devreis.apiproducts.dto.ProductDTO;
import devreis.apiproducts.model.Product;
import devreis.apiproducts.repository.ProductRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ProductDTO findById(UUID id) {
        Product product = findEntityProductById(id);
        return toDTO(product);
    }

    public ProductDTO updateById(UUID id, ProductDTO request) {
        Product product = findEntityProductById(id);

        product.setName(request.name());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());

        return toDTO(product);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    public Product findEntityProductById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
