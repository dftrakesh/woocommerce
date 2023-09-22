package io.github.dft.woocommerce.model.shipmenttrackingapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomTracking {
    private String trackingNumber;
    private String customTrackingLink;
    private String customTrackingProvider;
}