package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Reports {
    @JsonProperty("slug")
    public String slug;
    @JsonProperty("description")
    public String description;
    @JsonProperty("_links")
    public Links links;
}