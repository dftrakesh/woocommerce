package io.github.dft.woocommerce.model.orderapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LineItem {
    private Integer id;
    private Double price;
    private String sku;
    private String name;
    private Double total;
    private Integer quantity;
    private Integer productId;
    private Integer variationId;
    private String taxClass;
    private Double subtotal;
    private Double totalTax;
    private List<Tax> taxes;
    private Double subtotalTax;
}