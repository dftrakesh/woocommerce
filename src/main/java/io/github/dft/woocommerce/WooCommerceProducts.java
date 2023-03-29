package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.Product;
import io.github.dft.woocommerce.model.productapi.ProductWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WooCommerceProducts extends WooCommerceSdk {

    private final String PRODUCT_ENDPOINT = "/products";
    private final Integer MAX_LIMIT_PER_PAGE = 100;
    private final Integer DEFAULT_LIMIT_PER_PAGE = 10;

    public WooCommerceProducts(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductWrapper getAllProducts() {
        URI uri = baseUrl(PRODUCT_ENDPOINT);
        AtomicInteger pageNumber = new AtomicInteger(1);

        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(MAX_LIMIT_PER_PAGE));
        params.put("page", String.valueOf(pageNumber));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        ProductWrapper productWrapper = getRequestWrapped(request, ProductWrapper.class);
        while(true){
            uri = baseUrl(PRODUCT_ENDPOINT);
            params.put("page", String.valueOf(pageNumber.incrementAndGet()));
            uri = addParameters(uri, params);
            request = get(uri);
            ProductWrapper newProductWrapper = getRequestWrapped(request, ProductWrapper.class);
            if (newProductWrapper.size() == 0)
                break;
            productWrapper.addAll(newProductWrapper);
        }
        return productWrapper;
    }

    @SneakyThrows
    public ProductWrapper getProducts(int limitPerPage) {
        URI uri = baseUrl(PRODUCT_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(limitPerPage));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public ProductWrapper getProducts() {
        URI uri = baseUrl(PRODUCT_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(DEFAULT_LIMIT_PER_PAGE));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public ProductWrapper getProducts(HashMap<String, String> params) {
        URI uri = baseUrl(PRODUCT_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductWrapper.class);
    }

    @SneakyThrows
    public Product getProductById(Integer id) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, Product.class);
    }


    @SneakyThrows
    public Product createProduct(Product product) {
        URI uri = baseUrl(PRODUCT_ENDPOINT);
        HttpRequest request = post(uri, getString(product));

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product updateProduct(Integer productId, Product product) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productId));
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(product));

        return getRequestWrapped(request, Product.class);
    }

    @SneakyThrows
    public Product deleteProduct(Integer id) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, Product.class);
    }
}
