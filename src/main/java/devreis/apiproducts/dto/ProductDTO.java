package devreis.apiproducts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;
public record ProductDTO(
        UUID id,

        @NotBlank(message = "Name is required")
        String name,

        @Positive
        @NotNull(message = "Price is required")
        int price,

        @Positive
        @NotNull(message = "Quantity is required")
        int quantity
) {}
