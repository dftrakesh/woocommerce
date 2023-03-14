package io.github.dft.woocommerce.model.productapi.productshippingclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductShippingWrapper extends ArrayList<ProductShipping> {
}
