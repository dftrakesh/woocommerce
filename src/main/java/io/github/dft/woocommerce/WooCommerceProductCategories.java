package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productcategories.ProductCategory;
import io.github.dft.woocommerce.model.productapi.productcategories.ProductCategoryWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceProductCategories extends WooCommerceSdk {

    private String CATEGORY_ENDPOINT = "/products/categories";

    public WooCommerceProductCategories(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductCategoryWrapper getAllProductCategories() {
        URI uri = baseUrl(CATEGORY_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductCategoryWrapper.class);
    }

    @SneakyThrows
    public ProductCategory getProductCategoryById(Integer id) {
        String endpoint = CATEGORY_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        URI uri = baseUrl(CATEGORY_ENDPOINT);
        HttpRequest request = post(uri, getString(productCategory));

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory updateProductCategory(Integer productCategoryId, ProductCategory productCategory) {
        String endpoint = CATEGORY_ENDPOINT.concat("/").concat(String.valueOf(productCategoryId));
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(productCategory));

        return getRequestWrapped(request, ProductCategory.class);
    }

    @SneakyThrows
    public ProductCategory deleteProductCategory(Integer id) {
        String endpoint = CATEGORY_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, ProductCategory.class);
    }
}
