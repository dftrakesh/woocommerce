package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariation;
import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariationWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductVariations extends WooCommerceSdk {

    public WooCommerceProductVariations() {
        super();
    }

    @SneakyThrows
    public ProductVariationWrapper getAllProductVariations(String storeDomain,HashMap<String, String> params, Integer productId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productId)
                .concat(PRODUCT_VARIATION_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION,headerString)
                .build();

        return getRequestWrapped(request, ProductVariationWrapper.class);
    }

    @SneakyThrows
    public ProductVariation getProductVariationById(String storeDomain,HashMap<String, String> params, Integer productId, String productVariationId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productId)
                .concat(PRODUCT_VARIATION_ENDPOINT.concat(SLASH_CHARACTER) + productVariationId)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION,headerString)
                .build();

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation createProductVariation(String storeDomain,HashMap<String, String> params, Integer productId, ProductVariation productVariation) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productId)
                .concat(PRODUCT_VARIATION_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productVariation)))
                .header(AUTHORIZATION,headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation updateProductVariation(String storeDomain,HashMap<String, String> params,Integer productId, String productVariationId, ProductVariation productVariation) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productId)
                .concat(PRODUCT_VARIATION_ENDPOINT.concat(SLASH_CHARACTER) + productVariationId)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productVariation)))
                .header(AUTHORIZATION,headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation deleteProductVariation(String storeDomain,HashMap<String, String> params,Integer productId, String productVariationId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productId)
                .concat(PRODUCT_VARIATION_ENDPOINT.concat(SLASH_CHARACTER) + productVariationId)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        params.put("force","true");
        params.remove("consumer_key");
        params.remove("consumer_secret");
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .DELETE()
                .header(AUTHORIZATION,headerString)
                .build();

        return getRequestWrapped(request, ProductVariation.class);
    }
}
