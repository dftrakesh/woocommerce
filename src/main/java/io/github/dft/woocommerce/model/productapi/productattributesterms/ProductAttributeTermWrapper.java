package io.github.dft.woocommerce.model.productapi.productattributesterms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAttributeTermWrapper extends ArrayList<ProductAttributeTerm> {
}
