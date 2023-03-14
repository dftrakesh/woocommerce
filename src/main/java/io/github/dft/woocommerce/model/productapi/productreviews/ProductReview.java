package io.github.dft.woocommerce.model.productapi.productreviews;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import io.github.dft.woocommerce.model.productapi.Links;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductReview {
    private String id;
    private int rating;
    @JsonProperty("_links")
    private Links links;
    private int productId;
    private String status;
    private String review;
    private String reviewer;
    private boolean verified;
    private String reviewerEmail;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreated;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
    private Map<String,String> reviewerAvatarUrls;
}
