package devreis.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;
public record ProductDTO(
        UUID id,

        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Price is required")
        int price,

        @NotNull(message = "Quantity is required")
        int quantity
) {}
