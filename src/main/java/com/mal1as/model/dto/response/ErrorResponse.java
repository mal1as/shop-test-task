package com.mal1as.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response for statuses 4xx, 5xx")
public class ErrorResponse {

    @Schema(description = "Error message")
    private String message;

    @Schema(description = "Response status in text")
    private String status;

    @Schema(description = "Stack trace of exception")
    private String stackTrace;
}
