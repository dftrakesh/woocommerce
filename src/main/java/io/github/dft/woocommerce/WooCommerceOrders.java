package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.orderapi.Order;
import io.github.dft.woocommerce.model.orderapi.OrderWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceOrders extends WooCommerceSdk {

    String ORDER_ENDPOINT = "/orders";

    public WooCommerceOrders(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Order getOrderById(String storeDomain, Integer id) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, Order.class);
    }

    @SneakyThrows
    public OrderWrapper getAllOrders(String storeDomain) {
        URI uri = baseUrl(storeDomain, ORDER_ENDPOINT);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderWrapper.class);
    }
}