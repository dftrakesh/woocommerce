package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productattributesterms.ProductAttributeTerm;
import io.github.dft.woocommerce.model.productapi.productattributesterms.ProductAttributeTermWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductAttributeTerms extends WooCommerceSdk {

    private String ATTRIBUTE_ENDPOINT = "/products/attributes";
    private String TERMS_ENDPOINT = "/terms";

    public WooCommerceProductAttributeTerms(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductAttributeTermWrapper getAllProductAttributeTerms(String storeDomain, String productAttributeId) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(productAttributeId).concat(TERMS_ENDPOINT);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductAttributeTermWrapper.class);
    }

    @SneakyThrows
    public ProductAttributeTerm getProductAttributeTermById(String storeDomain, String productAttributeId,
                                                            String productAttributeTermId) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(productAttributeId).concat(TERMS_ENDPOINT).concat("/").concat(productAttributeTermId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm createProductAttributeTerm(String storeDomain, String productAttributeId,
                                                           ProductAttributeTerm productAttributeTerm) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(productAttributeId).concat(TERMS_ENDPOINT);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = post(uri, getString(productAttributeTerm));

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm updateProductAttributeTerm(String storeDomain, String productAttributeId,
                                                           String productAttributeTermId,
                                                           ProductAttributeTerm productAttributeTerm) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(productAttributeId).concat(TERMS_ENDPOINT).concat("/").concat(productAttributeTermId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = put(uri, getString(productAttributeTerm));

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm deleteProductAttributeTerm(String storeDomain, String productAttributeId, String productAttributeTermId) {
        String endpoint = ATTRIBUTE_ENDPOINT.concat("/").concat(productAttributeId).concat(TERMS_ENDPOINT).concat("/").concat(productAttributeTermId);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }
}
