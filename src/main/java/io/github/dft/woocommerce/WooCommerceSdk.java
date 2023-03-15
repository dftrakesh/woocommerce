package io.github.dft.woocommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

@AllArgsConstructor
@Builder(toBuilder = true)
public class WooCommerceSdk {

    protected HttpClient client;
    private ObjectMapper objectMapper;
    protected AccessCredential accessCredential;

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
                .thenApplyAsync(HttpResponse::body)
                .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
                .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    protected URI addParameters(URI uri, HashMap<String, String> params) {

        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();

        if (query != null)
            builder.append(query);

        for (Map.Entry<String,String> entry: params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(!builder.toString().isEmpty())
                builder.append("&");
            builder.append(key.concat("=").concat(value));
        }

        return new URI(uri.getScheme(),uri.getAuthority(),uri.getPath(),builder.toString(), uri.getFragment());
    }

    @SneakyThrows
    protected HttpRequest get(URI uri){
        return HttpRequest.newBuilder(uri)
                .GET()
                .header(AUTHORIZATION,header().toString())
                .build();
    }

    @SneakyThrows
    protected StringBuilder header(){
        StringBuilder originalInput = new StringBuilder(accessCredential.getConsumerKey())
                .append(":")
                .append(accessCredential.getConsumerSecret());
        return new StringBuilder("Basic ")
                .append(Base64.getEncoder().encodeToString(originalInput.toString().getBytes()));
    }
}
