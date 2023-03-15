package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.customerapi.Customer;
import io.github.dft.woocommerce.model.customerapi.CustomerWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceCustomers extends WooCommerceSdk {

    public WooCommerceCustomers(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public CustomerWrapper getAllCustomers(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(CUSTOMER_ENDPOINT)));
        uri = addParameters(uri, params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request, CustomerWrapper.class);
    }

    @SneakyThrows
    public Customer getCustomerById(String storeDomain, HashMap<String, String> params, Integer id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(CUSTOMER_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        uri = addParameters(uri, params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request, Customer.class);
    }
}
