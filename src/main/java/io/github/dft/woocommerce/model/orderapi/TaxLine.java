package io.github.dft.woocommerce.model.orderapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.customerapi.MetaData;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TaxLine {
    private int id;
    private int rateId;
    private String label;
    private String rateCode;
    private String taxTotal;
    private boolean compound;
    private String shippingTaxTotal;
    private List<MetaData> metaData;
}
