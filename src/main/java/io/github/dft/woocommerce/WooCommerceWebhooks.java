package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.webhookapi.WebHook;
import io.github.dft.woocommerce.model.webhookapi.WebHookWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceWebhooks extends WooCommerceSdk {
    public WooCommerceWebhooks() {
        super();
    }

    @SneakyThrows
    public WebHookWrapper getAllWebHook(String storeDomain,HashMap<String, String> params){
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request,WebHookWrapper.class);
    }

    @SneakyThrows
    public WebHook getWebHookById(String storeDomain,HashMap<String, String> params,Integer id){
        URI uri=URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        uri=addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        return getRequestWrapped(request,WebHook.class);
    }

    @SneakyThrows
    public WebHook createWebhook(String storeDomain,HashMap<String,String> params,WebHook webHook) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(getString(webHook)))
                .build();

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook updateWebhook(String storeDomain,HashMap<String,String> params,Integer webhookId, WebHook webHook) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + webhookId)));
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(getString(webHook)))
                .build();

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook deleteWebhook(String storeDomain,HashMap<String,String> params,Integer id) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + id)));
        params.put("force","true");
        uri = addParameters(uri,params);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .DELETE()
                .build();

        return getRequestWrapped(request, WebHook.class);
    }
}
