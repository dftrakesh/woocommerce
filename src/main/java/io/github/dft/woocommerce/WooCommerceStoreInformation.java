package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.storeinformationapi.StoreInformation;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.HttpConstants.API_BASE_END_POINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.STORE_INFORMATION_ENDPOINT;

public class WooCommerceStoreInformation extends WooCommerceSdk {

    public WooCommerceStoreInformation(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public StoreInformation getSystemInformation(String storeDomain, HashMap<String, String> params) {

        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(STORE_INFORMATION_ENDPOINT)));
        uri = addParameters(uri, params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request, StoreInformation.class);
    }
}