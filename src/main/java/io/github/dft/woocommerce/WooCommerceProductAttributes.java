package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productattributes.ProductAttribute;
import io.github.dft.woocommerce.model.productapi.productattributes.ProductAttributeWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceProductAttributes extends WooCommerceSdk {

    private String ATTRIBUTE_ENDPOINT = "/products/attributes";

    public WooCommerceProductAttributes(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductAttributeWrapper getAllProductAttributes() {
        URI uri = baseUrl(ATTRIBUTE_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductAttributeWrapper.class);
    }

    @SneakyThrows
    public ProductAttribute getProductAttributeById(String id) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        URI uri = baseUrl(ATTRIBUTE_ENDPOINT);
        HttpRequest request = post(uri, getString(productAttribute));

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute updateProductAttribute(String id, ProductAttribute productAttribute) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productAttribute));

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute deleteProductAttribute(String id) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(id);
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductAttribute.class);
    }
}
