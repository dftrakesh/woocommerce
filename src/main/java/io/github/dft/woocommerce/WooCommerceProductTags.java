package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTag;
import io.github.dft.woocommerce.model.productapi.producttags.ProductTagWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductTags extends WooCommerceSdk {

    public WooCommerceProductTags(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductTagWrapper getAllProductTags(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(TAG_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductTagWrapper.class);
    }

    @SneakyThrows
    public ProductTag getProductTagById(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(TAG_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag createProductTag(String storeDomain, HashMap<String, String> params, ProductTag productTag) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(TAG_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productTag)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag updateProductTag(String storeDomain, HashMap<String, String> params, String id, ProductTag productTag) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(TAG_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productTag)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductTag.class);
    }

    @SneakyThrows
    public ProductTag deleteProductTag(String storeDomain, HashMap<String, String> params, String id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(TAG_ENDPOINT.concat(SLASH_CHARACTER) + id)));
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

        return getRequestWrapped(request, ProductTag.class);
    }
}
