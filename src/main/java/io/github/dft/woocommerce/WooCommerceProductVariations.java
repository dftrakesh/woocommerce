package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariation;
import io.github.dft.woocommerce.model.productapi.productvariations.ProductVariationWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductVariations extends WooCommerceSdk {

    private String PRODUCT_ENDPOINT = "/products";
    private String PRODUCT_VARIATION_ENDPOINT = "/variations";

    public WooCommerceProductVariations(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductVariationWrapper getAllProductVariations(String storeDomain, Integer productId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariationWrapper.class);
    }

    @SneakyThrows
    public ProductVariation getProductVariationById(String storeDomain, Integer productId, String productVariationId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation createProductVariation(String storeDomain, Integer productId, ProductVariation productVariation) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = post(uri, getString(productVariation));

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation updateProductVariation(String storeDomain, Integer productId, String productVariationId, ProductVariation productVariation) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = put(uri, getString(productVariation));

        return getRequestWrapped(request, ProductVariation.class);
    }

    @SneakyThrows
    public ProductVariation deleteProductVariation(String storeDomain, Integer productId, String productVariationId) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId)).concat(PRODUCT_VARIATION_ENDPOINT).concat("/").concat(productVariationId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductVariation.class);
    }
}
