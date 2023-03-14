package io.github.dft.woocommerce.model.productapi.productreviews;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductReviewWrapper extends ArrayList<ProductReview> {
}
