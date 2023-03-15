package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.orderapi.orderrefund.OrderRefund;
import io.github.dft.woocommerce.model.orderapi.orderrefund.OrderRefundWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceOrderRefunds extends WooCommerceSdk {

    private String ORDER_ENDPOINT = "/orders";
    private String REFUND_ENDPOINT = "/refunds";

    public WooCommerceOrderRefunds(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public OrderRefundWrapper getAllOrderRefunds(String storeDomain, Integer orderId) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(orderId)).concat(REFUND_ENDPOINT);
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderRefundWrapper.class);
    }

    @SneakyThrows
    public OrderRefund getOrderRefundById(String storeDomain, Integer orderId, Integer refundId) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(orderId)).concat(REFUND_ENDPOINT).concat("/").concat(String.valueOf(refundId));
        URI uri = baseUrl(storeDomain, endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderRefund.class);
    }
}