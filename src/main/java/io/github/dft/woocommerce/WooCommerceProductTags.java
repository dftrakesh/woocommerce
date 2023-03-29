package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTag;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTagWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceProductTags extends WooCommerceSdk {

    private String TAG_ENDPOINT = "/products/tags";

    public WooCommerceProductTags(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductTagWrapper getAllProductTags() {
        URI uri = baseUrl(TAG_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductTagWrapper.class);
    }

    @SneakyThrows
    public ProductTag getProductTagById(String id) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag createProductTag(ProductTag productTag) {
        URI uri = baseUrl(TAG_ENDPOINT);
        HttpRequest request = post(uri, getString(productTag));

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag updateProductTag(String id, ProductTag productTag) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productTag));

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag deleteProductTag(String id) {
        String endpoint = TAG_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductTag.class);
    }
}
