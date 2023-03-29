package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.storeinformationapi.StoreInformation;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceStoreInformation extends WooCommerceSdk {

    private String STORE_INFORMATION_ENDPOINT = "/system_status";

    public WooCommerceStoreInformation(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public StoreInformation getSystemInformation() {
        URI uri = baseUrl(STORE_INFORMATION_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, StoreInformation.class);
    }
}