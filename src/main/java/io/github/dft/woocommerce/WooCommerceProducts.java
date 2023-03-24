package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.Product;
import io.github.dft.woocommerce.model.productapi.ProductWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProducts extends WooCommerceSdk {

    private String PRODUCT_ENDPOINT = "/products";

    public WooCommerceProducts(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductWrapper getAllProducts(String storeDomain) {
        URI uri = baseUrl(storeDomain, PRODUCT_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public ProductWrapper getOneProduct(String storeDomain) {
        URI uri = baseUrl(storeDomain, PRODUCT_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", "1");
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public Product getProductById(String storeDomain, Integer id) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, Product.class);
    }


    @SneakyThrows
    public Product createProduct(String storeDomain, Product product) {
        URI uri = baseUrl(storeDomain, PRODUCT_ENDPOINT);
        HttpRequest request = post(uri, getString(product));

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product updateProduct(String storeDomain, Integer productId, Product product) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = put(uri, getString(product));

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product deleteProduct(String storeDomain, Integer id) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, Product.class);
    }
}
