package com.mal1as.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Information about price")
public class PriceResponse {

    @Schema(description = "Price value")
    private Double price;
}
