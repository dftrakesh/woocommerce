package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productreviews.ProductReview;
import io.github.dft.woocommerce.model.productapi.productreviews.ProductReviewWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductReviews extends WooCommerceSdk {

    private String REVIEW_ENDPOINT = "/products/reviews";

    public WooCommerceProductReviews(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductReviewWrapper getAllProductReview() {
        URI uri = baseUrl(REVIEW_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductReviewWrapper.class);
    }

    @SneakyThrows
    public ProductReview getProductReviewById(String id) {
        String endpoint = REVIEW_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview createProductReview(ProductReview productReview) {
        URI uri = baseUrl(REVIEW_ENDPOINT);
        HttpRequest request = post(uri, getString(productReview));

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview updateProductReview(String id, ProductReview productReview) {
        String endpoint = REVIEW_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productReview));

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview deleteProductReview(String id) {
        String endpoint = REVIEW_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductReview.class);
    }
}
