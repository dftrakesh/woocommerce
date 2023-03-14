package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.productapi.productreviews.ProductReview;
import io.github.dft.woocommerce.model.productapi.productreviews.ProductReviewWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductReviews extends WooCommerceSdk {

    public WooCommerceProductReviews() {
        super();
    }

    @SneakyThrows
    public ProductReviewWrapper getAllProductReview(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REVIEW_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductReviewWrapper.class);
    }

    @SneakyThrows
    public ProductReview getProductReviewById(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REVIEW_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview createProductReview(String storeDomain, HashMap<String, String> params, ProductReview productReview) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(REVIEW_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productReview)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview updateProductReview(String storeDomain, HashMap<String, String> params, String id, ProductReview productReview) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REVIEW_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productReview)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductReview.class);
    }

    @SneakyThrows
    public ProductReview deleteProductReview(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REVIEW_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        params.put("force", "true");
        params.remove("consumer_key");
        params.remove("consumer_secret");
        uri = addParameters(uri, params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .DELETE()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductReview.class);
    }
}
