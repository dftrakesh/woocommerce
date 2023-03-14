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
public class LineItem {
    private int id;
    private int price;
    private String sku;
    private String name;
    private String total;
    private int quantity;
    private int productId;
    private int variationId;
    private String taxClass;
    private String subtotal;
    private String totalTax;
    private List<Tax> taxes;
    private String subtotalTax;
    private List<MetaData> metaData;
}
