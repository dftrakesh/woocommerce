package io.github.dft.woocommerce.model.shipmenttrackingapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.productapi.Links;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TrackingResponse {
    private String trackingId;
    private String trackingProvider;
    private String trackingLink;
    private String trackingNumber;
    private String dateShipped;
    @JsonProperty("_links")
    private Links links;
}