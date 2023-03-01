package io.github.dft.woocommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import lombok.SneakyThrows;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceSdk {

    protected AccessCredential accessCredential;
    protected HttpClient client;
    private ObjectMapper objectMapper;

    @SneakyThrows
    public WooCommerceSdk(AccessCredential accessCredential)  {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    public <T>CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                           HttpRequest request,
                                                           HttpResponse.BodyHandler<T> handler,
                                                           HttpResponse<T> response,int count){
        if(response.statusCode() == TOO_MANY_REQUEST_EXCEPTION_CODE && count < MAX_ATTEMPTS){
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request,handler)
                    .thenComposeAsync(resp -> tryResend(client,request,handler,resp,count+1));
        }
        return CompletableFuture.completedFuture(response);
    }

    @SneakyThrows
    protected String getString(Object body) {
        return objectMapper.writeValueAsString(body);
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .thenApplyAsync(stringHttpResponse -> {
                    System.out.println("body: " + stringHttpResponse.body());
                    return stringHttpResponse.body();
                })
                .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
                .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    protected void addParameters(URIBuilder uriBuilder, HashMap<String, String> params) {

        if (params == null || params.isEmpty()) return;

        for (String key : params.keySet()) {
            uriBuilder.addParameter(key, params.get(key));
        }
    }
}
