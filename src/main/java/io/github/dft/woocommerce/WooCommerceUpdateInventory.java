package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.Product;
import io.github.dft.woocommerce.model.updateinventory.UpdateInventory;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceUpdateInventory extends WooCommerceSdk {

    String PRODUCT_ENDPOINT = "/products";

    public WooCommerceUpdateInventory(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Product updateInventory(String storeDomain, Integer productID, UpdateInventory updateInventory) {
        String endpoint = PRODUCT_ENDPOINT.concat("/").concat(String.valueOf(productID));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = put(uri, getString(updateInventory));

        return getRequestWrapped(request, Product.class);
    }
}
