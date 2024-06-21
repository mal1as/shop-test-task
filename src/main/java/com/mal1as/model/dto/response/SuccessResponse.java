package com.mal1as.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response for statuses 2xx")
public class SuccessResponse<T> {

    @Schema(description = "Success or not operation")
    @Builder.Default
    private Boolean success = true;

    @Schema(description = "Content of this response")
    private T content;

    @Schema(description = "Total pages count for this response")
    @Builder.Default
    private Integer totalPages = 1;

    @Schema(description = "Total elements count for this response")
    @Builder.Default
    private Long totalCount = 1L;
}
