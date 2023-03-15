package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productattributes.ProductAttribute;
import io.github.dft.woocommerce.model.productapi.productattributes.ProductAttributeWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductAttributes extends WooCommerceSdk {

    public WooCommerceProductAttributes(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductAttributeWrapper getAllProductAttributes(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(ATTRIBUTE_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductAttributeWrapper.class);
    }

    @SneakyThrows
    public ProductAttribute getProductAttributeById(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(ATTRIBUTE_ENDPOINT + "/" + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute createProductAttribute(String storeDomain, HashMap<String, String> params, ProductAttribute productAttribute) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productAttribute)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute updateProductAttribute(String storeDomain, HashMap<String, String> params, String id, ProductAttribute productAttribute) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productAttribute)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductAttribute.class);
    }

    @SneakyThrows
    public ProductAttribute deleteProductAttribute(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + id)));
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

        return getRequestWrapped(request, ProductAttribute.class);
    }
}
