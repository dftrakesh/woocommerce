package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.orderapi.ordernote.OrderNote;
import io.github.dft.woocommerce.model.orderapi.ordernote.OrderNoteWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceOrderNotes extends WooCommerceSdk {

    private String ORDER_NOTE_ENDPOINT = "/notes";
    private String ORDER_ENDPOINT = "/orders";

    public WooCommerceOrderNotes(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public OrderNoteWrapper getAllOrderNotes(Integer orderId) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(orderId)).concat(ORDER_NOTE_ENDPOINT);
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderNoteWrapper.class);
    }

    @SneakyThrows
    public OrderNote getOrderNoteById(Integer orderId, Integer orderNoteId) {
        String endpoint = ORDER_ENDPOINT.concat("/").concat(String.valueOf(orderId)).concat(ORDER_NOTE_ENDPOINT).concat("/").concat(String.valueOf(orderNoteId));
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrderNote.class);
    }
}
