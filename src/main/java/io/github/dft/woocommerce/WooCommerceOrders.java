package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.orderapi.Order;
import io.github.dft.woocommerce.model.orderapi.OrderWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceOrders extends WooCommerceSdk {

    public WooCommerceOrders(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Order getOrderById(String storeDomain,HashMap<String, String> params,Integer id) {

        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ORDER_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request,Order.class);
    }

    @SneakyThrows
    public OrderWrapper getAllOrders(String storeDomain,HashMap<String, String> params){

        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(ORDER_ENDPOINT)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        return getRequestWrapped(request,OrderWrapper.class);
    }
}
