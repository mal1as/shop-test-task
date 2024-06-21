package com.mal1as.controller;

import com.mal1as.model.dto.request.PriceRequest;
import com.mal1as.model.dto.request.PurchaseRequest;
import com.mal1as.model.dto.response.ErrorResponse;
import com.mal1as.model.dto.response.PriceResponse;
import com.mal1as.model.dto.response.SuccessResponse;
import com.mal1as.service.PriceService;
import com.mal1as.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final PriceService priceService;
    private final PurchaseService purchaseService;

    @Operation(
            summary = "Calculate price",
            description = "Calculate final price including tax and discount"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(schema = @Schema(implementation = PriceResponse.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")})
            }
    )
    @PostMapping("/calculate-price")
    public ResponseEntity<SuccessResponse<PriceResponse>> calculatePrice(@Valid @RequestBody PriceRequest priceRequest) {
        return ResponseEntity.ok(SuccessResponse.<PriceResponse>builder()
                .content(PriceResponse.builder()
                        .price(priceService.calculatePrice(priceRequest))
                        .build())
                .build());
    }

    @Operation(
            summary = "Make a purchase",
            description = "Make a purchase with final price including tax and discount and payment processor"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(schema = @Schema(implementation = SuccessResponse.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")})
            }
    )
    @PostMapping("/purchase")
    public ResponseEntity<SuccessResponse<?>> makePurchase(@Valid @RequestBody PurchaseRequest purchaseRequest) {
        purchaseService.makePurchase(purchaseRequest);
        return ResponseEntity.ok(SuccessResponse.builder().build());
    }
}
