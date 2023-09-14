package io.github.dft.woocommerce.model.shipmenttrackingapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tracking {
    private String trackingNumber;
    private String trackingProvider;
}