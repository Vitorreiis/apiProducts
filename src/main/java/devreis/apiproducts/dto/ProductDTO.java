package devreis.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ProductDTO(
        UUID id,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Price is required")
        int price,

        @NotBlank(message = "Quantity is required")
        int quantity
) {}
