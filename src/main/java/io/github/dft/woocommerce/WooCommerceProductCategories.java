package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.productapi.productcategories.ProductCategory;
import io.github.dft.woocommerce.model.productapi.productcategories.ProductCategoryWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductCategories extends WooCommerceSdk {

    public WooCommerceProductCategories() {
        super();
    }

    @SneakyThrows
    public ProductCategoryWrapper getAllProductCategories(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(CATEGORY_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductCategoryWrapper.class);
    }

    @SneakyThrows
    public ProductCategory getProductCategoryById(String storeDomain, HashMap<String, String> params, Integer id) {
        String endpoint = CATEGORY_ENDPOINT.concat(SLASH_CHARACTER) + id;
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(endpoint)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory createProductCategory(String storeDomain, HashMap<String, String> params, ProductCategory productCategory) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(CATEGORY_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productCategory)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory updateProductCategory(String storeDomain, HashMap<String, String> params, Integer productCategoryId, ProductCategory productCategory) {
        String endpoint = CATEGORY_ENDPOINT.concat(SLASH_CHARACTER) + productCategoryId;
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(endpoint)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productCategory)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory deleteProductCategory(String storeDomain, HashMap<String, String> params, Integer id) {
        String endpoint = CATEGORY_ENDPOINT.concat(SLASH_CHARACTER).concat(String.valueOf(id));
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(endpoint)));
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

        return getRequestWrapped(request, ProductCategory.class);
    }
}
