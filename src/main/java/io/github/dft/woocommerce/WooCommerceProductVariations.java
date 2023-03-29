package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariation;
import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariationWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WooCommerceProductVariations extends WooCommerceSdk {

    private final String PRODUCT_ENDPOINT = "/products";
    private final String PRODUCT_VARIATION_ENDPOINT = "/variations";
    private final Integer MAX_LIMIT_PER_PAGE = 100;
    private final Integer DEFAULT_LIMIT_PER_PAGE = 10;

    public WooCommerceProductVariations(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductVariationWrapper getAllProductVariations(Integer productId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        AtomicInteger pageNumber = new AtomicInteger(1);
        URI uri = baseUrl(endpoint);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(MAX_LIMIT_PER_PAGE));
        params.put("page", String.valueOf(pageNumber));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        ProductVariationWrapper productVariationWrapper = getRequestWrapped(request, ProductVariationWrapper.class);
        while (true) {
            uri = baseUrl(endpoint);
            params.put("page", String.valueOf(pageNumber.incrementAndGet()));
            uri = addParameters(uri, params);
            request = get(uri);
            ProductVariationWrapper newProductVariationWrapper = getRequestWrapped(request, ProductVariationWrapper.class);
            if (newProductVariationWrapper.size() == 0) break;
            productVariationWrapper.addAll(newProductVariationWrapper);
        }
        return productVariationWrapper;
    }

    @SneakyThrows
    public ProductVariationWrapper getProductVariations(Integer productId, int limitPerPage) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(endpoint);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(limitPerPage));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariationWrapper.class);
    }

    @SneakyThrows
    public ProductVariationWrapper getProductVariations(Integer productId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(endpoint);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(DEFAULT_LIMIT_PER_PAGE));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariationWrapper.class);
    }

    @SneakyThrows
    public ProductVariationWrapper getProductVariations(Integer productId, HashMap<String, String> params) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(endpoint);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariationWrapper.class);
    }

    @SneakyThrows
    public ProductVariation getProductVariationById(Integer productId, String productVariationId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation createProductVariation(Integer productId, ProductVariation productVariation) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(endpoint);
        HttpRequest request = post(uri, getString(productVariation));

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation updateProductVariation(Integer productId, String productVariationId, ProductVariation productVariation) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productVariation));

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation deleteProductVariation(Integer productId, String productVariationId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductVariation.class);
    }
}
