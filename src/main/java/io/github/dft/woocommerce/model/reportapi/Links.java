package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Links {
    private List<Self> self;
    private List<Collection> collection;
    private List<About> about;
    private List<Product> product;
}