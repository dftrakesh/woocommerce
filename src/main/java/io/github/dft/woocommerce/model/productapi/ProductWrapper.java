package io.github.dft.woocommerce.model.productapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductWrapper extends ArrayList<Product> {
}
