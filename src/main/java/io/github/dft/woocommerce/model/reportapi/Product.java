package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {
    private String href;
}