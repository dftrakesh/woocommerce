package io.github.dft.woocommerce.model.orderapi.ordernote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderNote {
    private int id;
    private String note;
    @JsonProperty("_links")
    private Links links;
    private String author;
    private boolean addedByUser;
    private boolean customerNote;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreated;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
}
