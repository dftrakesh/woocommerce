package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productshippingclass.ProductShipping;
import io.github.dft.woocommerce.model.productapi.productshippingclass.ProductShippingWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.HttpConstants.*;

public class WooCommerceProductShippingClasses extends WooCommerceSdk {

    public WooCommerceProductShippingClasses(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductShippingWrapper getAllProductShippingClasses(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(SHIPPING_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductShippingWrapper.class);
    }

    @SneakyThrows
    public ProductShipping getProductShippingClassById(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(SHIPPING_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping createProductShippingClass(String storeDomain, HashMap<String, String> params, ProductShipping productShipping) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(SHIPPING_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productShipping)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping updateProductShippingClass(String storeDomain, HashMap<String, String> params, String id, ProductShipping productShipping) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(SHIPPING_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productShipping)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductShipping.class);
    }

    @SneakyThrows
    public ProductShipping deleteProductShippingClass(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(SHIPPING_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        params.put("force", "true");
        params.remove("consumer_key");
        params.remove("consumer_secret");
        uri = addParameters(uri, params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .DELETE()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductShipping.class);
    }
}
