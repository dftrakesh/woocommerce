package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.productapi.Product;
import io.github.dft.woocommerce.model.productapi.ProductWrapper;
import io.github.dft.woocommerce.model.updateinventory.UpdateInventory;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProducts extends WooCommerceSdk {
    public WooCommerceProducts() {
        super();
    }

    @SneakyThrows
    public ProductWrapper getAllProducts(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public Product getProductById(String storeDomain, HashMap<String, String> params, Integer id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, Product.class);
    }


    @SneakyThrows
    public Product createProduct(String storeDomain, HashMap<String, String> params, Product product) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(product)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product updateProduct(String storeDomain, HashMap<String, String> params, Integer productId, Product product) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER).concat(String.valueOf(productId)))));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(product)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product deleteProduct(String storeDomain, HashMap<String, String> params, Integer id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + id)));
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

        return getRequestWrapped(request, Product.class);
    }
}
