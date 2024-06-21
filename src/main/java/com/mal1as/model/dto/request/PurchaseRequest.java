package com.mal1as.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Schema(description = "Information to make a purchase")
public class PurchaseRequest extends PriceRequest {

    @Schema(description = "Payment processor name")
    @NotNull(message = "Payment processor must be not null")
    private String paymentProcessor;
}
