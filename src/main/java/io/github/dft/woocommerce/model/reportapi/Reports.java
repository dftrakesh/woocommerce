package io.github.dft.woocommerce.model.reportapi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Reports {
    @JsonProperty("slug")
    public String slug;
    @JsonProperty("description")
    public String description;
    @JsonProperty("_links")
    public Links links;
}