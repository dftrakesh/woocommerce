package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.webhookapi.WebHook;
import io.github.dft.woocommerce.model.webhookapi.WebHookWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class WooCommerceWebhooks extends WooCommerceSdk {

    private String WEBHOOK_ENDPOINT = "/webhooks";

    public WooCommerceWebhooks(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public WebHookWrapper getAllWebHook() {
        URI uri = baseUrl(WEBHOOK_ENDPOINT);
        HashMap<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, WebHookWrapper.class);
    }

    @SneakyThrows
    public WebHook getWebHookById(Integer id) {
        String endpoint = WEBHOOK_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook createWebhook(WebHook webHook) {
        URI uri = baseUrl(WEBHOOK_ENDPOINT);
        HttpRequest request = post(uri, getString(webHook));

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook updateWebhook(Integer webhookId, WebHook webHook) {
        String endpoint = WEBHOOK_ENDPOINT.concat("/").concat(String.valueOf(webhookId));
        URI uri = baseUrl(endpoint);
        HttpRequest request = put(uri, getString(webHook));

        return getRequestWrapped(request, WebHook.class);
    }

    @SneakyThrows
    public WebHook deleteWebhook(Integer id) {
        String endpoint = WEBHOOK_ENDPOINT.concat("/").concat(String.valueOf(id));
        URI uri = baseUrl(endpoint);
        HttpRequest request = delete(uri);

        return getRequestWrapped(request, WebHook.class);
    }
}