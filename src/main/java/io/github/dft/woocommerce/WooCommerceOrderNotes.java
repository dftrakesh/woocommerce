package io.github.dft.woocommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.woocommerce.model.orderapi.ordernote.OrderNote;
import io.github.dft.woocommerce.model.orderapi.ordernote.OrderNoteWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceOrderNotes extends WooCommerceSdk {

    public WooCommerceOrderNotes() {
        super();
    }

    @SneakyThrows
    public OrderNoteWrapper getAllOrderNotes(String storeDomain,HashMap<String, String> params, Integer orderId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ORDER_ENDPOINT.concat(SLASH_CHARACTER) + orderId)
                .concat(ORDER_NOTE_ENDPOINT)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request, OrderNoteWrapper.class);
    }

    @SneakyThrows
    public OrderNote getOrderNoteById(String storeDomain,HashMap<String, String> params,Integer orderId, Integer orderNoteId) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(ORDER_ENDPOINT.concat(SLASH_CHARACTER) + orderId)
                .concat(ORDER_NOTE_ENDPOINT.concat(SLASH_CHARACTER) + orderNoteId)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request, OrderNote.class);
    }

}
