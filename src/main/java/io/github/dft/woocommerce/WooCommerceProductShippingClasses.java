package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productshippingclass.ProductShipping;
import io.github.dft.woocommerce.model.productapi.productshippingclass.ProductShippingWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductShippingClasses extends WooCommerceSdk {

    private String SHIPPING_ENDPOINT = "/products/shipping_classes";

    public WooCommerceProductShippingClasses(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductShippingWrapper getAllProductShippingClasses() {
        URI uri = baseUrl(SHIPPING_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductShippingWrapper.class);
    }

    @SneakyThrows
    public ProductShipping getProductShippingClassById(String id) {
        String endpoint = SHIPPING_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping createProductShippingClass(ProductShipping productShipping) {
        URI uri = baseUrl(SHIPPING_ENDPOINT);
        HttpRequest request = post(uri, getString(productShipping));

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping updateProductShippingClass(String id, ProductShipping productShipping) {
        String endpoint = SHIPPING_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productShipping));

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping deleteProductShippingClass(String id) {
        String endpoint = SHIPPING_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductShipping.class);
    }
}
