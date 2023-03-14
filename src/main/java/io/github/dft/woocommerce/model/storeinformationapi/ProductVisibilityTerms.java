package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductVisibilityTerms {
    @JsonProperty("exclude-from-catalog")
    private String excludeFromCatalog;
    @JsonProperty("exclude-from-search")
    private String excludeFromSearch;
    private String featured;
    private String outofstock;
    @JsonProperty("rated-1")
    private String rated1;
    @JsonProperty("rated-2")
    private String rated2;
    @JsonProperty("rated-3")
    private String rated3;
    @JsonProperty("rated-4")
    private String rated4;
    @JsonProperty("rated-5")
    private String rated5;
}