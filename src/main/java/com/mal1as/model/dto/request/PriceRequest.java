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
@Schema(description = "Information to calculate price")
public class PriceRequest {

    @Schema(description = "Product id")
    @NotNull(message = "Product must be not null")
    private Long product;

    @Schema(description = "Tax number")
    @NotNull(message = "Tax number must be not null")
    private String taxNumber;

    @Schema(description = "Coupon code for discount")
    private String couponCode;
}
