package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.webhookapi.WebHook;
import io.github.dft.woocommerce.model.webhookapi.WebHookWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceWebhooks extends WooCommerceSdk {
    public WooCommerceWebhooks() {
        super();
    }

    @SneakyThrows
    public WebHookWrapper getAllWebHook(String storeDomain,HashMap<String, String> params){
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT))));

        addParameters(uriBuilder,params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request,WebHookWrapper.class);
    }

    @SneakyThrows
    public WebHook getWebHookById(String storeDomain,HashMap<String, String> params,Integer id){
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + id))));

        addParameters(uriBuilder,params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request,WebHook.class);
    }

    @SneakyThrows
    public WebHook createWebhook(String storeDomain,HashMap<String,String> params,WebHook webHook) {
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT))));
        addParameters(uriBuilder,params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .POST(HttpRequest.BodyPublishers.ofString(getString(webHook)))
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook updateWebhook(String storeDomain,HashMap<String,String> params,Integer webhookId, WebHook webHook) {
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + webhookId))));

        addParameters(uriBuilder,params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .PUT(HttpRequest.BodyPublishers.ofString(getString(webHook)))
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook deleteWebhook(String storeDomain,HashMap<String,String> params,Integer id) {
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(WEBHOOK_ENDPOINT.concat(SLASH_CHARACTER) + id))));
        params.put("force","true");
        addParameters(uriBuilder,params);
        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .DELETE()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request, WebHook.class);
    }
}
