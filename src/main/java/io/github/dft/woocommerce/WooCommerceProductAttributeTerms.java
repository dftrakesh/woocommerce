package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.productapi.productattributesterms.ProductAttributeTerm;
import io.github.dft.woocommerce.model.productapi.productattributesterms.ProductAttributeTermWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceProductAttributeTerms extends WooCommerceSdk {

    public WooCommerceProductAttributeTerms(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ProductAttributeTermWrapper getAllProductAttributeTerms(String storeDomain, HashMap<String, String> params, String productAttributeId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeId)
                .concat(TERMS_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductAttributeTermWrapper.class);
    }

    @SneakyThrows
    public ProductAttributeTerm getProductAttributeTermById(String storeDomain, HashMap<String, String> params,
                                                            String productAttributeId,
                                                            String productAttributeTermId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeId)
                .concat(TERMS_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeTermId)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION, headerString)
                .build();

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm createProductAttributeTerm(String storeDomain, HashMap<String, String> params, String productAttributeId,
                                                           ProductAttributeTerm productAttributeTerm) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeId)
                .concat(TERMS_ENDPOINT)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(productAttributeTerm)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm updateProductAttributeTerm(String storeDomain, HashMap<String, String> params,
                                                           String productAttributeId,
                                                           String productAttributeTermId,
                                                           ProductAttributeTerm productAttributeTerm) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeId)
                .concat(TERMS_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeTermId)));
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = "Basic ".concat(Base64.getEncoder().encodeToString(originalInput.getBytes()));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(productAttributeTerm)))
                .header(AUTHORIZATION, headerString)
                .header("Content-Type","application/json")
                .build();

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }

    @SneakyThrows
    public ProductAttributeTerm deleteProductAttributeTerm(String storeDomain, HashMap<String, String> params, String productAttributeId, String productAttributeTermId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ATTRIBUTE_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeId)
                .concat(TERMS_ENDPOINT.concat(SLASH_CHARACTER) + productAttributeTermId)));
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

        return getRequestWrapped(request, ProductAttributeTerm.class);
    }
}
