package com.mal1as.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Information to calculate price")
public class PriceRequest {

    @Schema(description = "Product id")
    @NotNull
    private Long product;

    @Schema(description = "Tax number")
    @NotNull
    private String taxNumber;

    @Schema(description = "Coupon code for discount")
    private String couponCode;
}
