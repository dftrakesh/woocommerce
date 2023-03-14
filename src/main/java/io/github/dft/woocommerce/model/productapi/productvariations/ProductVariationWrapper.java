package io.github.dft.woocommerce.model.productapi.productvariations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductVariationWrapper extends ArrayList<ProductVariation> {
}
