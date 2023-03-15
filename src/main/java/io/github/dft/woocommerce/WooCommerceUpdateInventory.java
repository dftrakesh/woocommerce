package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.Product;
import io.github.dft.woocommerce.model.updateinventory.UpdateInventory;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceUpdateInventory extends WooCommerceSdk{

    public WooCommerceUpdateInventory(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Product updateInventory(String storeDomain, HashMap<String, String> params, Integer productID, UpdateInventory updateInventory) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(PRODUCT_ENDPOINT.concat(SLASH_CHARACTER) + productID)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(updateInventory)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, Product.class);
    }
}
