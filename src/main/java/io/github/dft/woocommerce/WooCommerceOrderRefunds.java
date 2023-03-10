package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.orderapi.orderrefund.OrderRefund;
import io.github.dft.woocommerce.model.orderapi.orderrefund.OrderRefundWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceOrderRefunds extends WooCommerceSdk{

    public WooCommerceOrderRefunds() {
        super();
    }

    @SneakyThrows
    public OrderRefundWrapper getAllOrderRefunds(String storeDomain,HashMap<String, String> params,Integer orderId){
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ORDER_ENDPOINT.concat(SLASH_CHARACTER) + orderId)
                .concat(REFUND_ENDPOINT)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request,OrderRefundWrapper.class);
    }

    @SneakyThrows
    public OrderRefund getOrderRefundById(String storeDomain,HashMap<String, String> params,Integer orderId, Integer refundId){
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ORDER_ENDPOINT.concat(SLASH_CHARACTER) + orderId)
                .concat((REFUND_ENDPOINT.concat(SLASH_CHARACTER) + refundId))));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request,OrderRefund.class);
    }
}
