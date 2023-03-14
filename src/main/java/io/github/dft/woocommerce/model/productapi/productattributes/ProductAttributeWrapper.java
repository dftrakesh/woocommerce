package io.github.dft.woocommerce.model.productapi.productattributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAttributeWrapper extends ArrayList<ProductAttribute> {
}
