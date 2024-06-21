package com.mal1as.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Information to make a purchase")
public class PurchaseRequest extends PriceRequest {

    @Schema(description = "Payment processor name")
    @NotNull
    private String paymentProcessor;
}
