package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.orderapi.Order;
import io.github.dft.woocommerce.model.orderapi.OrderWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WooCommerceOrders extends WooCommerceSdk {

    private final String ORDER_ENDPOINT = "/orders";
    private final Integer MAX_LIMIT_PER_PAGE = 100;
    private final Integer DEFAULT_LIMIT_PER_PAGE = 10;

    public WooCommerceOrders(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Order getOrderById(Integer id) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, Order.class);
    }

    @SneakyThrows
    public OrderWrapper getAllOrders() {
        URI uri = baseUrl(ORDER_ENDPOINT);
        AtomicInteger pageNumber = new AtomicInteger(1);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(MAX_LIMIT_PER_PAGE));
        params.put("page", String.valueOf(pageNumber));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        OrderWrapper orderWrapper = getRequestWrapped(request, OrderWrapper.class);
        while (true) {
            uri = baseUrl(ORDER_ENDPOINT);
            params.put("page", String.valueOf(pageNumber.incrementAndGet()));
            uri = addParameters(uri, params);
            request = get(uri);
            OrderWrapper newOrderWrapper = getRequestWrapped(request, OrderWrapper.class);
            if (newOrderWrapper.size() == 0)
                break;
            orderWrapper.addAll(newOrderWrapper);
        }
        return orderWrapper;
    }

    @SneakyThrows
    public OrderWrapper getOrders(int limitPerPage) {
        URI uri = baseUrl(ORDER_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(limitPerPage));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderWrapper.class);
    }

    @SneakyThrows
    public OrderWrapper getOrders() {
        URI uri = baseUrl(ORDER_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", String.valueOf(DEFAULT_LIMIT_PER_PAGE));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderWrapper.class);
    }

    @SneakyThrows
    public OrderWrapper getOrders(HashMap<String, String> params) {
        URI uri = baseUrl(ORDER_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderWrapper.class);
    }
}