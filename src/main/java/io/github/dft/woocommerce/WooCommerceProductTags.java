package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTag;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTagWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductTags extends WooCommerceSdk {

    private String TAG_ENDPOINT = "/products/tags";

    public WooCommerceProductTags(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductTagWrapper getAllProductTags(String storeDomain) {
        URI uri = baseUrl(storeDomain, TAG_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductTagWrapper.class);
    }

    @SneakyThrows
    public ProductTag getProductTagById(String storeDomain, String id) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag createProductTag(String storeDomain, ProductTag productTag) {
        URI uri = baseUrl(storeDomain, TAG_ENDPOINT);
        HttpRequest request = post(uri, getString(productTag));

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag updateProductTag(String storeDomain, String id, ProductTag productTag) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = put(uri, getString(productTag));

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag deleteProductTag(String storeDomain, String id) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductTag.class);
    }
}
