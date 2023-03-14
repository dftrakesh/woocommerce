package io.github.dft.woocommerce.model.productapi.productcategories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategoryWrapper extends ArrayList<ProductCategory> {
}
