package io.github.dft.woocommerce.model.productapi.productcategories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductCategory {
    private int id;
    private int count;
    private int parent;
    private String name;
    private String slug;
    private Image image;
    @JsonProperty("_links")
    private Links links;
    private int menuOrder;
    private String display;
    private String description;
}
