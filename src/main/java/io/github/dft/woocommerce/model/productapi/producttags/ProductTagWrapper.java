package io.github.dft.woocommerce.model.productapi.producttags;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTagWrapper extends ArrayList<ProductTag> {
}
