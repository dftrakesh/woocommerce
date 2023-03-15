package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.customerapi.Customer;
import io.github.dft.woocommerce.model.customerapi.CustomerWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceCustomers extends WooCommerceSdk {

    private String CUSTOMER_ENDPOINT = "/customers";

    public WooCommerceCustomers(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public CustomerWrapper getAllCustomers(String storeDomain) {
        URI uri = baseUrl(storeDomain, CUSTOMER_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, CustomerWrapper.class);
    }

    @SneakyThrows
    public Customer getCustomerById(String storeDomain, Integer id) {
        URI uri = baseUrl(storeDomain, CUSTOMER_ENDPOINT.concat("/").concat(String.valueOf(id)));
        HttpRequest request = get(uri);

        return getRequestWrapped(request, Customer.class);
    }
}
